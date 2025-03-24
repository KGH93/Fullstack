package a0324.도서1;

import java.util.ArrayList;

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
}
