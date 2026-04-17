function loadBooks() {
    fetch("http://localhost:9090/books")
        .then(res => res.text())
        .then(data => {
            const list = document.getElementById("bookList");
            list.innerHTML = "";

            const lines = data.split("\n");

            lines.forEach(line => {
                if(line.trim() === "") return;

                const parts = line.split("->");
                const id = parts[0].trim();
                const name = parts[1].trim();

                const card = document.createElement("div");
                card.className = "card";

                card.innerHTML = `
                    <h3>${name}</h3>
                    <p>ID: ${id}</p>
                    <button class="borrow" onclick="borrowBook(${id})">Borrow</button>
                    <button class="return" onclick="returnBook(${id})">Return</button>
                `;

                list.appendChild(card);
            });
        });
}

function borrowBook(id) {
    fetch(`http://localhost:9090/borrow?id=${id}`)
        .then(() => {
            alert("Book borrowed!");
            loadBooks();
        });
}

function returnBook(id) {
    fetch(`http://localhost:9090/return?id=${id}`)
        .then(() => {
            alert("Book returned!");
            loadBooks();
        });
}