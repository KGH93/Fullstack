package a0324.도서1;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private ArrayList<Library> librarys;   //Library를 객체를 리스트(묶음으로 저장 할 수 있는 배열종류)
    private ArrayList<Library> booklocation;   //Library를 객체중 대여한 객체를 저장하는 리스트


    public LibraryManager(){
        librarys = new ArrayList<>();     //전체 책목록을 담을 리스트
        booklocation = new ArrayList<>();       //대출한 목록 리스트
        librarys.add(new Library("This is Java", "Shin", "Section A", "979-11-691-229-8"));
        librarys.add(new Library("First Encounter with React", "Lee Inje", "Section B", "979-11-6921-169-7"));
        librarys.add(new Library("The Principles of Web Standards", "Ko Kyunghee", "Section C", "979-11-6303-622-7"));
             //더미 데이터 1,2,3 
    }




    public void allLibrary() {
        System.out.println("대출 가능한 도서보기");
        // for(int i = 0; i < librarys.size(); i ++){
        //     Library library = librarys.get(i);
        //     if( library.isAvailable()){
        //         System.out.println(library);
        //     }
        // }
        for(Library library:librarys){    //향상된 for문
            if(library.isAvailable()){
                System.out.println(library);
            }
        }
    }




    public boolean booklocation(String name) {
        for(Library library:librarys){
            if(library.getTitle().equalsIgnoreCase(name) && library.isAvailable()){   // equalsIgnoreCase로 비교하면 대소문자 다인정해줌
                library.book();  // Library클래스에서 만든 대출이 실행되면 available에 = false 넣어주는 메서드
                booklocation.add(library);    //대출한 도서를 booklocation 리스트에 추가
                return true;
            }
        }
        return false;
    }




    public void booklocation() {
        System.out.println("대출한 도서 :");
        for(Library loca : booklocation){
            System.out.println(loca);
            // System.out.println(loca.toString()); same
        }
    }




    public void addLibrary(String newtitle, String newauthor, String newlocation, String newisbn) {
        // Library abc = new Library(newtitle,newauthor,newlocation,newisbn); 아래가 요약식
        librarys.add(new Library(newtitle,newauthor,newlocation,newisbn));
    }





// arraylist 추가할때 add 설정할때 set 제거할떄 remove
// 어레이 배열 삭제하기
    public void delLibrary(String dname) {
        boolean result = false;
        for(Library library : librarys){
            if (library.getTitle().equalsIgnoreCase(dname)){
                if(library.isAvailable()){ //대여중이 아닐때(대여가능할때)
                    librarys.remove(library);
                    result = true;
                    break;
                }else{
                    result = false;
                    break;
                }
            }
        }
        if(result){   //if(result == true)
            System.out.println("삭제됨");
        }else{
            System.out.println("삭제 안됨");
        }
    }




    // 배열 업데이트하기
    public void updateLibrary(String uname) {
        int i = 0;
        
        // index는 수정할 도서의 인덱스를 저장하는 변수입니다. 초기값을 -1로 설정함으로써, 도서를 찾지 못했음을 나타내는 용도로 사용됩니다.
        // 코드에서 도서를 검색할 때, 만약 도서가 리스트에 존재하지 않으면 index는 여전히 -1로 남아 있게 됩니다. 
        // 이후에 index가 -1인지 확인하여 도서를 찾지 못했음을 판단하고, 적절한 메시지를 출력할 수 있습니다. 
        // 이는 오류를 방지하고, 코드의 가독성을 높이는 데 도움이 됩니다.

        // menu는 사용자가 수정할 항목을 선택하는 변수입니다. 초기값을 -1로 설정하는 것은 사용자가 아직 선택을 하지 않았음을 나타냅니다.
        // 사용자가 입력한 값이 1에서 4 사이의 유효한 값인지 확인하기 위해, menu의 초기값을 -1로 설정하여 기본적으로 잘못된 선택을 나타내는 것입니다. 
        // 이후 사용자가 입력한 값이 유효하지 않을 경우, "1~4번 중에 입력하세요."라는 메시지를 출력하여 다시 입력을 유도할 수 있습니다.
        
        int index = -1;
        int menu = -1;

        
        boolean flag = true;
        Scanner scan = new Scanner(System.in);   //alt shift L O 하면 util.scanner 작성됨
        Library newA = new Library();  // 빈라이브러리 객체를 하나 만든다.
        System.out.println(uname);
        for(Library a : librarys){  //librarys 리스트를 순회하며 같은 이름 있는지 찾음
            i++;
            if(a.getTitle().equalsIgnoreCase(uname)){
                index = i - 1 ; // indext = 0,1,2; //실제 찾은 인덱스번호
                newA = a;  //이름이 같으면 생성된 객체 newA에 넣는다.
            }
            System.out.println(a.getTitle().equals(uname) + " " + a.getTitle() + " " + uname);
        }
        if(index != -1){  //index == -1 이 아니면 수정하려는 도서 이름 찾은것
            System.out.print("뭘 수정할건데?\n 1.도서 이름 \t 2.도서 저자 \t 3.도서 위치 \t 4.도서ISBN \n >>");
            menu = scan.nextInt();
            scan.nextLine(); // \n같이 불필요한 내용을 지워준다
            while (flag) {
                switch (menu) {
                    case 1:
                        System.out.println("수정할 이름");
                        newA.setTitle(scan.nextLine());  //키보드 입력한 도서이름으로 newA객체 변경 
                        librarys.set(index,newA);  //해당인덱스번호에 수정한 객체를 삽입
                        flag = false;
                        break;
                    case 2:
                        System.out.println("수정할 저자");
                        newA.setAuthor(scan.nextLine());  //키보드 입력한 도서이름으로 newA객체 변경 
                        librarys.set(index,newA);  //해당인덱스번호에 수정한 객체를 삽입
                        flag = false;
                        break;
                    case 3:
                        System.out.println("수정할 위치");
                        newA.setLocation(scan.nextLine());  //키보드 입력한 도서이름으로 newA객체 변경 
                        librarys.set(index,newA);  //해당인덱스번호에 수정한 객체를 삽입
                        flag = false;
                        break;
                    case 4:
                        System.out.println("수정할 isbn");
                        newA.setIsbn(scan.nextLine());  //키보드 입력한 도서이름으로 newA객체 변경 
                        librarys.set(index,newA);  //해당인덱스번호에 수정한 객체를 삽입
                        flag = false;
                        break;
                
                    default:
                        System.out.println("1~4번 중에 입력하세요.");
                        break;
                }
            }
        }else{
            System.out.println("찾는 도서가 없어 업데이트를 할 수 없습니다.");
        }
    }



// 조회하기
    public void showLibrary(String sname) {
        for(Library b : librarys){
            if(b.getTitle().equalsIgnoreCase(sname)){
                System.out.println(b.toString());
            }
        }
    }


}
