package a0331.Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // 앞에서 부터 해당원소가 위치 할 곳을 탐색하고 해당 위치에 삽입
        int [] array = {63,34,25,17,22,11,90};
        SelectionSort1(array);
        System.out.println("선택 정렬" + Arrays.toString(array));
    }

    private static void SelectionSort1(int[] array) {
        int n = array.length; //배열7개 7
        for(int i = 0; i < n-1; i++){  //7개배열 은 [6]까지돔. n-1
            int minIndex = i;  //0
            for( int j = i+1; j < n; j++){
                if(array[j] < array [minIndex]){  //
                    minIndex = j; 
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
