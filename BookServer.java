import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;

public class BookServer {

    static Liberary lib = new Liberary();

    public static void main(String[] args) throws Exception {

        lib.addBook("Java", "James Gosling");
        lib.addBook("Python", "Guido");

        HttpServer server = HttpServer.create(new InetSocketAddress(9090), 0);

        server.createContext("/books", (exchange) -> {
            String response = getBooks();
            send(exchange, response);
        });

        server.createContext("/borrow", (exchange) -> {
            int id = Integer.parseInt(exchange.getRequestURI().getQuery().split("=")[1]);
            boolean result = lib.borrowBook(id);
            send(exchange, result ? "Borrowed" : "Failed");
        });

        server.createContext("/return", (exchange) -> {
            int id = Integer.parseInt(exchange.getRequestURI().getQuery().split("=")[1]);
            lib.returnBook(id);
            send(exchange, "Returned");
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server running on port 8080 🚀");
    }

    static String getBooks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i + " -> Book\n");
        }
        return sb.toString();
    }

    static void send(HttpExchange exchange, String response) throws IOException {
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}