package a0325;

public class Overloading {
    public static void main(String[] args) {
        Mathadd math = new Mathadd();


        System.out.println(math.add(3,5));
        System.out.println(math.add(3.5,4.5));
        System.out.println(math.add(3,5.5));
        System.out.println(math.add(4.5,3));
        System.out.println(math.add(4,3,7));
    }
}




class Mathadd {
    public int add(int a, int b){
        return a + b ;
    }
    public int add(int a, int b, int c){
        return a + b + c ;
    }
    public double add(double a, int b){
        return a + b ;
    }
    public double add(int a, double b){
        return a + b ;
    }
    public double add(double a, double b){
        return a + b ;
    }
}