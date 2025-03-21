package a0321.Book;

import java.util.Scanner;

public class Liabrary {

    private static Book[] bookArray = new Book[100];
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        addBooks();

        while (run) {
            System.out.println("==========================================================================");
            System.out.println("1.addBook | 2.listBook | 3.borrowBook | 4.returnBook | 5.Exit");
            System.out.println("==========================================================================");
            int selectNum = Integer.parseInt(scan.nextLine());

            if (selectNum == 1) {
                addBook();
            } else if (selectNum == 2) {
                listBook();
            } else if (selectNum == 3) {
                borrowBook();
            } else if (selectNum == 4) {
                returnBook();
            } else if (selectNum == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }

    private static void addBook() {
        System.out.println("==================");
        System.out.println("선택>1");
        System.out.println("==================");
        System.out.print("책 제목을 입력해주세요: ");
        String title = scan.nextLine();
        System.out.print("책 저자를 입력해주세요: ");
        String author = scan.nextLine();
        String status = "available";
        // String status = unavailable;

        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] != null) {
                if (bookArray[i].getTitle().equals(title) && bookArray[i].getAuthor().equals(author)) {
                    System.out.println("결과: 이미 존재하는 책입니다.");
                    return; // 중복된 책이 존재하면 메서드 종료
                }
            }
        }

        Book newBook = new Book(title, author, status);

        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] == null) {
                bookArray[i] = newBook;
                System.out.printf("책 제목 : %s", title);
                System.out.printf("저자 : %s", author);
                System.out.println(" 결과: 책이 추가되었습니다!");
                break;
            }
        }
    }

    private static void listBook() {
        System.out.println("================");
        System.out.println("선택>2");
        System.out.println("================");
        for (int i = 0; i < bookArray.length; i++) {
            Book book = bookArray[i];
            if (book != null) {
                System.out.println("책 제목 : " + book.getTitle());
                System.out.println("     ");
                System.out.println("책 저자 : " + book.getAuthor());
                System.out.println("     ");
                System.out.println("상태 : " + book.getStatus());
                System.out.println();
            }
        }
    }

    private static void borrowBook() {
        System.out.println("================");
        System.out.println("선택>3");
        System.out.println("================");
        System.out.print("책 제목 : ");
        String title = scan.nextLine();
        Book book = scanBook(title);
        if (book == null) {
            System.out.println("결과: 입력하신 책은 존재하지 않습니다.");
            return;
        }
        if (book.getStatus().equals("available")) {
            System.out.println("결과: 입력하신 책은 이미 대여상태입니다.");
            return;
        }
        book.setStatus("unavailable");
        System.out.println("결과: 대여를 성공하셨습니다.");
    }

    private static Book scanBook(String title) {
        Book book = null;
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] != null) {
                String dbtitle = bookArray[i].getTitle();
                if (dbtitle.equals(title)) {
                    book = bookArray[i];
                    break;
                }
            }
        }
        return book;
    }

    private static void returnBook() {
        System.out.println("================");
        System.out.println("선택>4");
        System.out.println("================");
        System.out.print("책 제목: ");
        String title = scan.nextLine();
        Book book = scanBook(title);
        if (book == null) {
            System.out.println("결과: 입력하신 책은 존재하지 않습니다.");
            return;
        }
        book.setStatus("available");
        System.out.println("결과: 책을 반납하셨습니다.");
    }

    private static void addBooks() {

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Available");
        Book book2 = new Book("1984", "George Orwell", "Available");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "Available");
        Book book4 = new Book("Moby Dick", "Herman Melville", "Available");
        Book book5 = new Book("Pride and Prejudice", "Jane Austen", "Available");
        Book book6 = new Book("The Catcher in the Rye", "J.D. Salinger", "Available");
        Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", "Available");
        Book book8 = new Book("Fahrenheit 451", "Ray Bradbury", "Available");
        Book book9 = new Book("Brave New World", "Aldous Huxley", "Available");
        Book book10 = new Book("The Odyssey", "Homer", "Available");

        bookArray[0] = book1;
        bookArray[1] = book2;
        bookArray[2] = book3;
        bookArray[3] = book4;
        bookArray[4] = book5;
        bookArray[5] = book6;
        bookArray[6] = book7;
        bookArray[7] = book8;
        bookArray[8] = book9;
        bookArray[9] = book10;
    }
}
