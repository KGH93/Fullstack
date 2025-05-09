package a0319;

public class PrimeScorer {
    public static void main(String[] args) {
        String name[] = {"Elena","Suzie","John","Emily","Neda","Kate","Alex","Daniel","Sam"};
        int score[] = {65,74,23,75,68,96,88,98,54};
        int prime = 0;
        for ( int i = 0; i < 9; i++){
            if( prime < score[i]){
                prime = score[i];
            }
        }
        for ( int i = 0; i < 9; i++){
            if (score[i]==prime){
                System.out.printf("1등: %s(%d점)", name[i],prime);
            }
        }
    }
}
