package a0319;

public class Ex03 {
    public static void main(String[] args) {
        int[][] score = {
            {100, 95 , 46},
            {20, 20 , 20},
            {30, 30 , 30},
            {40, 40 , 40}
        };

        int[] columnSum = new int[score[0].length];   //열 합계 계산용 { 190,185,136}

        System.out.println("번호   국어   영어   수학   합계   평균");
        System.out.println("=========================================");
      

        for ( int i = 0; i < score.length; i++){
            int sum = 0;
            for (int j = 0; j < score[i].length; j++){
                sum += score[i][j];
                columnSum[j] +=score[i][j];
            }
            double average = (double)sum/ score[i].length;
            System.out.printf("%2d %7d %6d %6d %6d %7.1f%n",i+1,score[i][0],score[i][1],score[i][2],sum,average);
        }
        System.out.println("=========================================");
        System.out.printf("총점 %5d %6d %6d%n",columnSum[0],columnSum[1],columnSum[2]);
    }
}

