package a0318;

import java.util.Scanner;
public class Fork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("삼겹살 몇인분 입니까");
        int n = scan.nextInt();
        double kcal = Serving(n);
        System.out.printf("삼겹살%d인분의 칼로리:%.2fkcal",n,kcal);
        }
        
            // public static double Serving(int n) {
            //     int g = n * 180;
            //     double totalkcal = g * 5.179;
            //     return totalkcal;
            // }

            public static double Serving(int amount) {
                int g = amount * 180;
                double totalkcal = g * 5.179;
                return totalkcal;
            }
        }