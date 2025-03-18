package a0318;

// 원기둥의 부피 반지름 * 반지름 * 높이 * 3.14
public class Cylinder {
    public static void main(String[] args) {
        
        double r = 7;
        double h = 5;
        double v = volume(r,h);
                System.out.printf("반지름이 %.1f, 높이가 %.1f인 원기둥의 부피%.1f", r, h, v);
            }
        
            public static double volume(double r, double h) {
                return Math.PI*r*r*h;
            }

            // Math.PI = 파이
}
