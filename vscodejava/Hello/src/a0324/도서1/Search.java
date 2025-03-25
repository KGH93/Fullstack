package a0324.도서1;

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();
        // 생성과 동시에 더미데이터도 생성메서드에 들어있으므로 만들어짐
        boolean flag = true;
        while (flag) {
            System.out.println("\n도서검색 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 대출가능한 도서");
            System.out.println("2. 도서 대출하기");
            System.out.println("3. 대출한 도서보기");
            System.out.println("4. 도서 추가하기");
            System.out.println("5. 도서 삭제하기");
            System.out.println("6. 도서정보 수정하기");
            System.out.println("7. 도서내용 보기");
            System.out.println("8. 종료");
            System.out.print("원하는 작업을 선택하세요 >> ");
            int choice = scan.nextInt();
            scan.nextLine(); // 혹시모를 이상한문제 제거
            switch (choice) {
                case 1:
                    System.out.println("대출가능한 도서");
                    manager.allLibrary();  //대출 가능한 도서 조회 메서드
                    break;


                case 2:
                    System.out.println("도서 대출하기");
                    System.out.println("대출하려는 도서의 이름을 입력하세요 : ");
                    String libraryName = scan.nextLine();
                    if(manager.booklocation(libraryName)){   //대출 가능/ 불가능을 boolean으로 만들었으므로 메서드도 boolean으로 생성
                        System.out.println("도서가 성공적으로 대출되었습니다.");
                    }else{
                        System.out.println("도서가 대출 가능하지 않거나 존재하지 않습니다.");
                    }
                    break;


                case 3:
                    System.out.println("대출한 도서보기");
                    manager.booklocation();  //대출한 도서 조회 메서드
                    break;


                case 4:
                    System.out.println("도서 추가하기");
                    System.out.print("추가 도서이름 : ");
                    String newtitle = scan.nextLine();
                    System.out.print("추가 도서저자 : ");
                    String newauthor = scan.nextLine();
                    System.out.print("도서 위치 : ");
                    String newlocation = scan.nextLine();
                    System.out.print("도서의 ISBN : ");
                    String newisbn = scan.nextLine();
                    scan.nextLine();  //개행문자 초기화
                    manager.addLibrary(newtitle,newauthor,newlocation,newisbn);
                    System.out.println(": 도서추가 완료");
                    break;


                case 5:
                    System.out.println("삭제 시작");
                    System.out.println("삭제하려는 도서 이름을 적어주세요");
                    String dname = scan.nextLine();
                    if( dname.equals("")){
                        System.out.println("삭제하려는 도서 이름을 다시입력 \n 이름?>>");
                        dname = scan.nextLine();
                    }
                    manager.delLibrary(dname);
                    System.out.println("삭제 완료");
                    break;


                case 6:
                    System.out.println("수정시작");
                    System.out.println("수정하려는 도서 이름을 적어주세요");
                    String uname = scan.nextLine();
                    if( uname.equals("")){
                        System.out.println("수정하려는 도서 이름을 다시입력 \n 이름?>>");
                        uname = scan.nextLine();
                    }
                    manager.updateLibrary(uname);
                    System.out.println("수정 완료");
                    break;


                case 7:
                    System.out.println("조회 시작 \n 도서 이름 입력");
                    String sname = scan.nextLine();
                    if( sname.equals("")){
                        System.out.println("조회하려는 도서 이름을 다시입력 \n 이름?>>");
                        sname = scan.nextLine();
                    }
                    manager.showLibrary(sname);
                    System.out.println("조회 완료");
                    break;


                case 8:
                    System.out.println("종료");
                    flag = false;
                    scan.close();  //scanner 종료
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
