package a0327.wordList;

import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Brain book = new Brain();
        Scanner scan = new Scanner(System.in);

        while (true) {
            book.Menu();
            String select =scan.nextLine();
            if(select.equals("1")){
                book.AddWord();
            }
            else if(select.equals("2")){
                book.WordSearch();
            }
            else if(select.equals("3")){
                book.DeleteWord();
            }
            else if(select.equals("4")){
                book.Test();
            }
            else if(select.equals("5")){
                book.WordList();
            }
            else if(select.equals("6")){
                book.Exit();
                break;
            }else{
                System.out.println("1~6까지의 숫자만 입력하세요");
            }

        }
        scan.close();
    }
}
