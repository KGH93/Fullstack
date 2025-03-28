package a0328.도서;

import java.util.Scanner;

public class MainLibrary {
    public static void main(String[] args) {
        BookDAO book = new BookDAO();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1. 도서정보 입력");
            System.out.println("2. 도서정보 삭제");
            System.out.println("3. 도서정보 검색");
            System.out.println("4. 도서정보 수정");
            System.out.println("5. 전체 도서 목록 보기");
            System.out.println("6. 도서목록을 파일로 저장");
            System.out.println("7. 파일에서 도서 목록 불러오기");
            System.out.println("0. 종료");
            System.out.print("->");
            int choice;
            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                choice =-1;
                scan.nextLine();
            }
            if ( choice == 1){
                book.bookInsert();
            }else if( choice == 2){
                book.bookDelete();
            }else if( choice == 3){
                book.bookSearch();
            }else if( choice == 4){
                book.bookUpdate();
            }else if( choice == 5){
                book.printAll();
            }else if( choice == 6){
                try {
                    book.dataSave();
                    System.out.println("도서목록을 저장했습니다.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if( choice == 7){
                    book.dataLoad();
                    System.out.println("도서목록을 불러왔습니다.");
            }else if( choice == 0){
                System.out.println("종료합니다.");
                scan.close();
                System.exit(0);
            }else{
                System.out.println("잘못 선택하셨습니다.");
            }
        
        }
    
    }

}
