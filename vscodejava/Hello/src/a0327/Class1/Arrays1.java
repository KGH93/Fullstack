package a0327.Class1;

import java.util.Arrays;
import java.util.List;

public class Arrays1 {
    public static void main(String[] args) {
        int [] numbers = {5,2,8,1,3};
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        // 배열을 문자열로 변환 Arrays.toString();
        System.out.println("배열 내용" + Arrays.toString(numbers));


        // 배열을 정렬 Arrays.sort();
        Arrays.sort(numbers);
        System.out.println("졍렬된 배열: " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 5);
        System.out.println("값 5의 위치: " + index);



        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};
        //두배열을 비교 Arrays.equals(,));
        System.out.println("arr1과 arr2같은가? " + Arrays.equals(arr1, arr2));
        System.out.println("arr1과 arr2같은가? " + Arrays.equals(arr1, arr3));
        System.err.println();


        // 배열을 원하는 숫자로 채움 Arrays.fill(,);
        int [] numfill = new int[5];
        Arrays.fill(numfill,7);
        System.out.println("배열 내용" + Arrays.toString(numfill));
        System.out.println();



        int[] original = {1, 2, 3, 4, 5};
        // 배열의 처음부터 원하는 부분까지 복사 Arrays.copyOf(,);
        int[] copy = Arrays.copyOf(original, 3); // 처음 3개 요소 복사
        System.out.println("복사된 배열: " + Arrays.toString(copy));
        System.out.println();


        // 배열의 원하는 순번을 시작부터 끝을 지정해 복사 Arrays.copyOfRange(,);
        int[] original1 = {10,20,30,40,50};
        int[] copy1 = Arrays.copyOfRange(original1,1,4);// 1번부터 4번 전까지 복사
        System.out.println("실제복사된 배열: " + Arrays.toString(copy1));
        System.out.println();


        // 배열의 문자열을 포함하게하함 List<String>
        String [] fruits = {"Apple", "Banana", "Cherry"};
        List<String> fruitsList = Arrays.asList(fruits);
        System.out.println("리스트: " + fruitsList);
    }
}
