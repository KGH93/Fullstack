package a0318;

public class Gasoline {
    public static void main(String[] args) {
        double l = 8.86;
        double d = 182.736;
        double eff = fuelefficiency(l,d);
        System.out.printf("휘발유 %.2fL를 충전한 자동차의 총 주행거리가 %.3fkm일때 이 자동차의 연비는 %.2f km/L이다.",l,d,eff);
            }
        
            private static double fuelefficiency(double l, double d) {
                return d/l;
            }
}
// fuelefficiency = 메소드 이름
// double l, double d = 매개변수, 입력변수, 파라미터
// return d/l; =  반환값
//private static double fuelefficiency //double =반환타입
// 메서드 p160
