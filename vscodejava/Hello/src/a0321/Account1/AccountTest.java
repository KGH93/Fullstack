package a0321.Account1;

public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account();
        // acc.balance = 1000;
        // System.out.printf("잔액:%d",acc.balance);
        acc.setBalance(1000);
        System.out.printf("잔액: %d",acc.getBalance());
        
            }
        }
        
        
        
        
        class Account{
            // 자신외 모든 클래스의 접근을 거부한다.  //캡슐화 get set 사용
            private int balance;

            // 게터 메소드 //세터 메소드가 void라 리턴을위해 따로 메소드를 만듬;
            public int getBalance(){
                return balance;
            }
        
            // 세터 메소드  //private라 직접 접근이 불가능해 받는 메소드를 따로만듬.
            public void setBalance(int b) {   // public 접근이쉽고 void 반환값x
                balance = b;
            }
    
}