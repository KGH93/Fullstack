package a0319;

public class Ex01 {
    public static void main(String[] args) {
        int arr1 [] = {65, 74, 23, 75, 68, 96, 88, 98, 54};
        int i = TopArr(arr1);
        int j = MidArr(arr1, i);
        System.out.printf("두번째로 큰수 :%d", arr1[j]);


            }
        
            private static int TopArr(int[] arr) {
                int TopArr = 0;
                for ( int i = 0 ; i < arr.length; i++){
                    if(arr[TopArr] < arr[i]){
                        TopArr = i;
                    }
                }
                return TopArr;
            }
            private static int MidArr(int[] arr, int i) {
                int MidArr = 0;
                for ( int j = 0; j < arr.length; j++){
                    if(j == i){
                        continue;
                    }
                    if( arr[MidArr] < arr[j]){
                        MidArr = j;
                    }
                }
                return MidArr;
            }
}
        

