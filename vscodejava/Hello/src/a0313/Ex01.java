package a0313;

public class Ex01 {
    public static void main(String[] args) {
        //세자리 정수의 각 자릿수 총합을 출력하려 한다.
        //num = 374 
        //정수 374의 각 자릿수의 총합 : 14
        //힌트 1. 3+7+4 = 14
        //힌트 2. 는 % 나머지와 / 나누기를 적절히 이용
        //힌트 3. 100으로 나누고 10으로 나누고 나머지 이용

        int num = 943;
        int result = (num / 100 ) + ( num % 100 / 10) + ( num % 10);

        System.out.println("세자리 정수 "+num+" 의 각 자릿수의 총합은 "+result);
        System.out.printf("정수 %d의 자릿수의 총합은 %d", num ,result);
    }
}
