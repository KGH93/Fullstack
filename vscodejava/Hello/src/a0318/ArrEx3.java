package a0318;

import java.util.Arrays;

public class ArrEx3 {
    public static void main(String[] args) {
        int[] arrInt = new int[5];  //길이가 5개인 배열객체 생성
        arrInt[0] = 1;
        arrInt[1] = 2;
        arrInt[2] = 3;
        arrInt[3] = 4;
        arrInt[4] = 5;
        for(int num:arrInt){
            System.out.println(num);
        }
        System.out.println(Arrays.toString(arrInt));    // [1,2,3,4,5]
    }
}
