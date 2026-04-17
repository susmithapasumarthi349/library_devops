import java.util.ArrayList;
public class Liberary {
    private ArrayList<Book>arr;
    public Liberary(){
        arr =new ArrayList<>();
    }
    public boolean addBook(String name,String Author){
        try{
            arr.add(new Book(name,Author));
        }catch(Exception ex){
            System.out.println("Exception happend at the time of adding the book");
            return false;
        }
        return true;
    }
    public void displayBooks(){
        if(arr.isEmpty()==true)return;
        for(int i = 0;i<arr.size();i++){
            System.out.println((i+1)+". "+arr.get(i).getBookname());
        }
    }
    public void showBorrowBook(){
        if(arr.isEmpty()==true){
            System.out.println("No Books in the Liberary");
            return;
        }
        for(int i = 0;i<arr.size();i++){
            if(arr.get(i).isBorrowed()==true){
                System.out.println((i+1)+". "+arr.get(i).getBookname());
            } 
        }
    }
    public void returnBook(int IndexOfBook){
        if(!(IndexOfBook >= 0 && IndexOfBook < arr.size()))return;
        arr.get(IndexOfBook).setBorrowedStatus(true);
    }
    public boolean borrowBook(int IndexOfBook){
        if(!(IndexOfBook >= 0 && IndexOfBook < arr.size()))return false;
        if(arr.get(IndexOfBook).isBorrowed())return false;
        arr.get(IndexOfBook).setBorrowedStatus(true);
        return true;
    }
}