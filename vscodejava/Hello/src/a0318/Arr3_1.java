package a0318;

import java.util.Arrays;

public class Arr3_1 {
    public static void main(String[] args) {
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = {100,95,80,70,60};
        char[] chArr = {'a','b','c','d','f'};
        // for문을 돌려서 iArr1 에 1,2,3,4,5,6,7,8,9 들어가도록해주세요

        // iArr1[0] = 1;

        for (int i=0; i < iArr1.length; i++){
            iArr1[i]=i + 1;
        }
        // System.out.println(Arrays.toString(iArr1));
        for (int i=0; i < iArr1.length; i++){
            System.out.println(iArr1[i]+" , ");
        }
        System.err.println();
        for (int i=0; i < iArr2.length; i++){
            iArr2[i] = (int)(Math.random()*10)+1;
    }
        System.out.println(Arrays.toString(iArr2));
        System.out.println();

        System.out.println(iArr3);
        // 참조변수
        // System.out.println();
        System.out.println(chArr);
        // println 메서드가 char 배열일때만 이렇게 동작하도록 작성되었다.
    }
}
