package a0327.member1;

import java.util.Scanner;

public class Membership {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MemberMager memberMager = new MemberMager();
        while (true) {
            System.out.println("\n===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 검색");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 회원 목록 보기");
            System.out.println("6. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scan.nextInt();
            scan.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    System.out.println("회원 추가");
                    System.out.print("이름을 입력하세요. : ");
                    String nname = scan.nextLine();
                    System.out.print("나이를 입력하세요. : ");
                    int nage = scan.nextInt();
                    System.out.print("이메일을 입력하세요. : ");
                    String nemail = scan.nextLine();
                    scan.nextLine();
                    memberMager.addMember(nname,nage,nemail);
                    System.out.println("회원 추가가 완료 되었습니다.");
                    break;
                    
                case 2:
                    System.out.print("검색할 회원의 이름을 입력하세요. : ");
                    String fname = scan.nextLine();
                    Member foundMember = memberMager.findMember(fname);
                    if(foundMember != null){
                        System.out.println("회원정보 : " + foundMember);
                    }else{
                        System.out.println("해당이름의 회원이 없습니다.");
                    }
                    break;

                case 3:
                    System.out.print("수정할 회원의 이름을 입력하세요. :");
                    String uname = scan.nextLine();
                    System.out.print("나이를 입력하세요. : ");
                    int uage = scan.nextInt();
                    System.out.print("이메일을 입력하세요. : ");
                    String uemail = scan.nextLine();
                    scan.nextLine();
                    memberMager.updateMember(uname,uage,uemail);
                    break;

                case 4:
                    System.out.print("삭제할 회원의 이름을 입력하세요. :");
                    String dname = scan.nextLine();
                    scan.nextLine();
                    memberMager.deleteMember(dname);
                    break;

                case 5:
                    System.out.println("=====전체 회원 목록=====");
                    // 회원목록을 출력하는
                    // displayAllmember()메서드 만들기
                    memberMager.displayAllmember();
                    break;

                case 6:
                    System.out.println("종료");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                    break;
            }
        }
    }
}
