    package a0328.도서;

    import java.util.ArrayList;
    import java.util.Scanner;

    public class BookDAO {
        private ArrayList<Book> books;
        Scanner scan = new Scanner(System.in);
        FileClass file = new FileClass("도서","books");
        public BookDAO(){
            books = new ArrayList<>();
            Book b1 = new Book("자바의 정석", "남궁성", "12345", 32000);
            Book b2 = new Book("Effective Java", "Joshua Bloch", "54321", 45000);
            Book b3 = new Book("Clean Code", "Robert C. Martin", "67890", 38000);
            Book b4 = new Book("스프링 부트와 AWS", "이동욱", "98765", 28000);
            Book b5 = new Book("코틀린 인 액션", "Dmitry Jemerov", "13579", 40000);
            books.add(b1);
            books.add(b2);
            books.add(b3);
            books.add(b4);
            books.add(b5);
        }


        
        private int searchIndex() {
            int index = -1;
            System.out.println("ISBN을 입력해주세요");
            System.out.print("->");
            String isbn = scan.next();
            for( int i = 0; i < books.size(); i ++){
                if(books.get(i).getIsbn().equals(isbn)){
                    index = i;
                    break;
                }
            }
            return index;
        }

        public void bookInsert() {
            Book b = new Book();
            System.out.println("<도서 추가하기>");
            scan.nextLine();
            System.out.print("도서 제목: ");
            b.setName(scan.nextLine());
            System.out.print("도서 저자: ");
            b.setAuthor(scan.nextLine());
            System.out.print("도서 isbn: ");
            b.setIsbn(scan.nextLine());
            System.out.print("도서 가격: ");
            b.setPrice(scan.nextDouble());
            books.add(b);
            System.out.println("도서가 추가 되었습니다.");
        }


        public void bookDelete() {
            System.out.println("<도서정보 삭제>");
            int index = searchIndex();
            if ( index == -1){
                System.out.println("일치하는 도서가 없습니다.");
            }else{
                String isbn = books.get(index).getIsbn();
                books.remove(index);
                System.out.println("입력하신" + isbn + " 도서를 삭제했습니다.");
            }
            
        }




        public void bookSearch() {
            System.out.println("<도서정보 검색>");
            int index = searchIndex();
            if(index == -1){
                System.out.println("일치하는 도서가 없습니다.");
            }else{
                System.out.println("도서제목\t 도서저자\t 도서ISBN\t 도서가격\n");
                Book s = books.get(index);
                System.out.println(s.toString());
            }
        }


        public void bookUpdate() {
            System.out.println("<도서정보 수정>");
            int index = searchIndex();
            if(index == -1){
                System.out.println("일치하는 도서가 없습니다.");
            }else{
                Book u = new Book();
                System.out.println(books.get(index).getIsbn() + " 도서 정보 수정합니다.");
                System.out.print("도서 제목 : ");
                u.setName(scan.next());
                System.out.print("도서 저자 : ");
                u.setAuthor(scan.next());
                System.out.print("도서 가격 : ");
                u.setPrice(scan.nextDouble());
                u.setIsbn(books.get(index).getIsbn());
                books.set(index,u);
                System.out.println("도서가 수정되었습니다.");
            }

        }


        public void printAll() {
            System.out.println("     책 제목\t       책 저자\t                ISBN\t          가격\n" + "================================================================================");
            for(int i = 0; i < books.size(); i ++){
                System.out.println(books.get(i).toString());
            }
        }



        public void dataSave() throws Exception{
            file.create();
            String str = "도서제목\t 도서저자\t 도서ISBN\t 도서가격\n" + "======================================================";
            for(int i = 0; i < books.size(); i++){
                str += books.get(i).toString() + "\n";
            }
            file.write(str);
        }



        public void dataLoad(){
            try {
                file.read();
            } catch (Exception e) {
                System.out.println("읽을 파일이 없습니다.");
            }
        }

    }