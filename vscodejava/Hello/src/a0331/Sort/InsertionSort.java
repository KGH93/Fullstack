package a0331.Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        // 앞에서 부터 해당원소가 위치 할 곳을 탐색하고 해당 위치에 삽입
        int [] array = {63,34,25,17,22,11,90};
        InsertionSort1(array);
        System.out.println("sour Array" + Arrays.toString(array));
    }

    private static void InsertionSort1(int[] array) {
        int n = array.length;
        for(int i = 1; i < n; i++){
            int key = array[i];  //key = [1]; //34  //25
            int j = i - 1;  //j = [0]; //63  //63  
            while (j>=0 && array[j] > key) { //63
                array[j+1] = array[j];//63 
                j--;
            }
            array[j+1] = key; //34
            //34,63,25,17,22,11,90  //한바퀴돌았을때
            //34,25,63,17,22,11,90  //두바퀴돌았을때
        }
    }
}
