package a0319;

public class Ex02 {
    public static void main(String[] args) {
        int arr1 [] = {65, 74, 23, 75, 68, 96, 88, 98, 54};
        int MidArr = getMidArr(arr1);
        System.out.println("배열 : [65, 74, 23, 75, 68, 96, 88, 98, 54]");
        System.out.printf("두번째로 큰수 :%d", arr1[MidArr]);


            }
        
            private static int getMidArr(int[] arr) {
                int MidArr = 0;
                int TopArr = getTopArr(arr);
                for ( int i = 0 ; i < arr.length; i++){
                    if( i == TopArr){
                        continue; // 최대값이 들어간 인덱스 번호일때 for문으로 복귀
                    }
                    if(arr[MidArr] < arr[i]){
                        MidArr = i;
                    }
                }
                return MidArr;
            }

            private static int getTopArr(int[] arr){
                int TopArr = 0; //최고값 인덱스벉호 초기화
                for ( int i =0; i < arr.length; i++){
                    if(arr[i] > arr[TopArr]){
                        TopArr = i;
                    }
                }
                return TopArr;
            }
}
        

