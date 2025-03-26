package a0319;

public class PrimeScorer1 {
    public static void main(String[] args) {
        String name[] = {"Elena","Suzie","John","Emily","Neda","Kate","Alex","Daniel","Sam"};
        int score[] = {65,74,23,75,68,96,88,98,54};
        int i = topIndex(score);

        System.out.printf("1등 : %s(%d점)",name[i],score[i]);
               
            }
        
            private static int topIndex(int[] arr) {
                int topIdx = 0;  //가장 큰 값의 인덱스 초기화
                for (int i =0; i < arr.length; i++){
                    if(arr[topIdx] < arr[i]){
                        topIdx = i; //topIdx를 i로 변경
                    }
                }
                return topIdx; //가장큰 인덱스 번호를 반환
            }
}
