import java.util.Scanner;
public class Executer {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Liberary lib=new Liberary();
        while(true){
            System.out.println("***Liberary Menu");
            System.out.println("***1. Show Book");
            System.out.println("***2. Return Book");
            System.out.println("***3. Borrow Book");
            int ch = sc.nextInt();
            switch  (ch) {
                case 1:
                    lib.displayBooks();
                    break;
                case 2:
                    lib.showBorrowBook();
                    System.out.println("which book you are returning ? ");
                    int ind=sc.nextInt();
                    lib.returnBook(ind);
                    break;
                case 3:
                    lib.displayBooks();
                    System.out.println("Enter the index of the book you want to borrow : ");
                    int ind2=sc.nextInt();
                    if(lib.borrowBook(ind2)){
                        System.out.println("Book will be issued");
                    }else System.out.println("book can be issued");
                    break;
                default:

                    break;
            }
            System.out.println("you want to continue ?(1/0)");
            ch = sc.nextInt();
            if(ch !=1)
            System.out.println("thanks for visiting");
            break;
        }
        sc.close();
    }
}
