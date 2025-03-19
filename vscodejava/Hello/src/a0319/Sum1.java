package a0319;

public class Sum1 {
    public static void main(String[] args) {
        int sum = 0;
        float average = 0f;
        int [] score = {100,80,100,100,90};
        //sum 과 average를 구하시오

        // sum = score[0]+score[1]...

        for(int i = 0; i < score.length; i++){
            sum += score[i];
        }
        System.out.println(sum);

        // average = sum /5   
        average = sum / (float)score.length;

        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + average);
    }
}
