package a0326.string;

public class StringEx1 {
    public static void main(String[] args) {
        String str = new String("java");
        System.out.println("원본문자열 : " + str);
        String str1 = "java";
        System.out.println("원본문자열 : " + str1);


        for(int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i)+ " ");
        }
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i)+ " " +"원본문자열 : " + str);
        }
    }
}
