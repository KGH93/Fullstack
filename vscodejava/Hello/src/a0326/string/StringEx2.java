package a0326.string;

public class StringEx2 {
    public static void main(String[] args) {
        String str = new String("abcd");
        System.out.println("원본문자열: " + str);


        System.out.println(str.compareTo("bcdf"));   //두 문자 다르면 -1
        System.out.println(str.compareTo("abcd"));   //두 문자 같으면 0

        System.out.println(str.compareTo("Abcd"));   //32 a의 유니코드값 97 ,A의 유니코드 값 65
        System.out.println(str.compareToIgnoreCase("Abcd"));   //두문자 같으면 0
        System.out.println("compareTo() 메소드 호출 후 원본 문자열 : " + str);
    }
}
