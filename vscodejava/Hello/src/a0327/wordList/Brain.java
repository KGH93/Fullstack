package a0327.wordList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Brain implements Interface{
    static HashMap<String, String> word = new HashMap<>();

    public Brain(){
        word.put("Peach", "복숭아");
        word.put("Plum", "자두");
        word.put("Pomegranate", "석류");
        word.put("Persimmon", "감");
    }


    @Override
    public void Menu() {
        System.out.println("---- 선택 해주세요. ----");
        System.out.println(" 1. 단어 등록 ");
        System.out.println(" 2. 단어 조회 ");
        System.out.println(" 3. 단어 삭제 ");
        System.out.println(" 4. 테스트 ");
        System.out.println(" 5. 단어 목록보기");
        System.out.println(" 6. 종료 ");
        System.out.println("-----------------------");
    }
    

    @Override
    public void AddWord() {
        String Eng = null;
        String Kor = null;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("등록할 영단어를 입력하세요.(목록으로 돌아가려면 Menu 입력):");
            Eng = scan.nextLine();
            if(Eng.equals("Menu") || Eng.equals("menu")){
                break;
            }else{
                if(word.containsKey(Eng) == true) {
                    System.out.println("이미 입력된 단어입니다. 수정을 원하시면 삭제후 다시입력");
                } else{
                    System.out.print("뜻을 입력해 주세요. : ");
                    Kor = scan.nextLine();

                    try{
                        word.put(Eng, Kor);
                    }catch(Exception e){
                        System.out.println("다시 입력해주세요");
                        e.printStackTrace();
                    }finally{
                        System.out.println("입력 되었습니다.");
                    }
                }
            }
        }
    }


    
    @Override
    public void WordSearch() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("조회하고싶은 영단어를 입력해보세요. (목록으로 돌아가려면 Menu 입력): ");
            String Eng = scan.nextLine();
            if(Eng.equals("Menu") || Eng.equals("menu")){
                break;
            }else{
                if(word.containsKey(Eng) == true) {
                    System.out.println(word.get(Eng)); //key에 해당되는 Value(단어뜻)
                } else{
                    System.out.println("등록되지않은 단어입니다.");
                }
            }
        }
    }

    @Override
    public void DeleteWord() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("==== 단어 목록 ====");
            if(word.isEmpty()){
                System.out.println("저장된 단어가 없어요");
            }else{
                for(Map.Entry<String, String> entry : word.entrySet()){
                    System.out.println("   " + entry.getKey() + " : " + entry.getValue());
                }
            }
            System.out.println("=======================");

            System.out.println("삭제하고 싶은 단어를 입력하세요.(목록으로 돌아가려면 Menu 입력): ");
            String del = scan.nextLine().trim();  //입력값 앞뒤 공백제거
            if(del.equalsIgnoreCase("menu")){  //대소문자 구분없이 비교
                System.out.println("메뉴로 돌아갑니다.");
                break;
            }
            if(word.containsKey(del)){
                System.out.println("입력한 단어 "+ del + " : " + word.remove(del) + "이 삭제되었습니다.");
            }else{
                System.out.println("존재하지 않는 단어입니다.");
            }
        }
    }

    @Override
    public void Test() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void WordList() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Exit() {
        // TODO Auto-generated method stub
        
    }


    

}
