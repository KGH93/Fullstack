package a0318;



public class EvenOdd {
    public static void main(String[] args) {
        System.out.println(evenOrOdd(4));
        System.out.println(evenOrOdd(7));
            }
        
            // private static String evenOrOdd(int num) {
            //     if( num%2 ==0){
            //         return "Even";
            //     }else{
            //         return "Odd";
            //     }
            //}
            private static String evenOrOdd(int num) {
                return (num%2==0) ? "Even":"Odd";
            }
}

