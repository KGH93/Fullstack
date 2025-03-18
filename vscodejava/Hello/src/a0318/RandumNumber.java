package a0318;

public class RandumNumber {
    public static void main(String[] args) {
        int n = rollDice();
                System.out.printf("주사위의 눈: %d", n);


            }
        
            public static int rollDice() {
                // int x = (int)(Math.random()*6 +1);
                double x = Math.random() * 6;
                int temp = (int) x;
                return temp + 1;
            }
}
