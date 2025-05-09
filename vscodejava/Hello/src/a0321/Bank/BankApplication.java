package a0321.Bank;

import java.net.Socket;
import java.util.Scanner;

public class BankApplication {

        private static Account[] accountArray = new Account[100];
        //모든 계좌정보를 저장 - 하나의 배열에 저장하므로 새로운 배열을 만들 필요가 없어 static을 쓴다.
        private static Scanner scan = new Scanner(System.in);

            public static void main(String[] args) {

            boolean run = true;

            while (run) {
                System.out.println("=========================================================");
                System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.이체 | 6.종료");
                System.out.println("=========================================================");
                int selectNo = Integer.parseInt(scan.nextLine());

                if(selectNo ==1){
                    createAccount();
                }else if(selectNo ==2){
                    accountList();
                }else if(selectNo ==3){
                    deposit();  //예금
                }else if(selectNo ==4){
                    withdraw();  //출금
                }else if(selectNo ==5){
                    transfer();  //이체
                }else if(selectNo ==6){
                    run = false;
                }
            }
            System.out.println("프로그램 종료");
        }



        //계좌생성
        private static void createAccount(){
            System.out.println("================");
            System.out.println("계좌생성");
            System.out.println("================");
            System.out.print("계좌번호");
            String ano = scan.nextLine();
            System.out.print("계좌주");
            String owner = scan.nextLine();
            System.out.print("초기입금액:");
            int balance = Integer.parseInt(scan.nextLine());

            Account newAccount = new Account(ano, owner, balance); //키보드로 입력된 값을 생성자로 초기화


            // 계좌등록시 중복된 계좌 등록 불가 하게 하는 for문
            for (int i = 0; i < accountArray.length; i++) {
                if (accountArray[i] != null) {
                    if (accountArray[i].getAno().equals(ano)) {
                        System.out.println("결과: 이미 존재하는 계좌입니다.");
                        return; 
                    }
                }
            }

            for(int i=0; i < accountArray.length; i++){
                if(accountArray[i]==null){
                    accountArray[i] = newAccount;
                    System.out.println("결과 : 계좌가 생성되었습니다.");
                    break;
                }
            }
            // accountArray[0] = newAccount"110-110","gildong",10000)
            // accountArray[1] = newAccount"110-111","sunja",20000)
        }



        //계좌조회
        private static void accountList(){
            System.out.println("================");
            System.out.println("계좌조회");
            System.out.println("================");
            for(int i = 0; i < accountArray.length; i++){
                Account account = accountArray[i];
                if(account != null){
                    System.out.print(account.getAno());
                    System.out.print("     ");
                    System.out.print(account.getOwner());
                    System.out.print("     ");
                    System.out.print(account.getBalance());
                    System.out.println();
                }
            }
        }




        //입금
        private static void deposit(){
            System.out.println("================");
            System.out.println("  예금  ");
            System.out.println("================");
            System.out.print("계좌번호: ");
            String ano = scan.nextLine();  //ano아니어도됌 a b여도됌 /잠시저장할뿐
            System.out.print("예금액: ");
            int money = Integer.parseInt(scan.nextLine());
            Account account = findAccount(ano);
            if(account == null){
                System.out.println("결과 : 계좌가 없습니다.");
                return;
            }
            account.setBalance(account.getBalance() + money);
            // 현재의 잔액을 gatter로 불러와서 예금액(money)를 더한 후
            // setBalance로 더한 금액을 넣기

        }




        //입금 출금에 사용하는 accountArray안의 계좌찾기
        private static Account findAccount(String ano) {
                Account account = null;  //비어있는 객체를 만든다. (반환되는 내용을 담아갈 객체)
                     for( int i=0; i < accountArray.length; i++){
                        if(accountArray[i] != null){  // accountArray[i]의 배열의 내용이 있으면
                            String dbano = accountArray[i].getAno();  //배열의 계좌번호를 
                         if(dbano.equals(ano)){
                            account = accountArray[i];
                            break;
                        }
                    }
                }
                return account;
         }

         


        //출금
        private static void withdraw(){
            System.out.println("================");
            System.out.println("  출금  ");
            System.out.println("================");
            System.out.print("계좌번호: ");
            String ano = scan.nextLine();  //ano아니어도됌 a b여도됌 /잠시저장할뿐
            System.out.print("출금액: ");
            int money = Integer.parseInt(scan.nextLine());
            Account account = findAccount(ano);
            if(account == null){
                System.out.println("결과 : 계좌가 없습니다.");
                return;
            }
            if(account.getBalance() < money){
                System.out.println("결과 : 잔액이 부족합니다.");
                return;
            }
            account.setBalance(account.getBalance() - money);
            // 현재의 잔액을 gatter로 불러와서 예금액(money)를 더한 후
            // setBalance로 뺀 금액을 넣기

        }



        //이체
        private static void transfer(){
            System.out.println("================");
            System.out.println("  이체  ");
            System.out.println("================");
            System.out.print("출금할 계좌번호: ");
            String ano = scan.nextLine();  //ano아니어도됌 a b여도됌 /잠시저장할뿐
            System.out.print("입금할 계좌번호: ");
            String ano1 = scan.nextLine(); 
            System.out.print("이체금액: ");
            int money = Integer.parseInt(scan.nextLine());
            Account withdrawaccount = findAccount(ano);
            Account depositaccount = findAccount(ano1);
            if(withdrawaccount == null && depositaccount ==null){
                System.out.println("결과 : 계좌가 없습니다.");
                return;
            }
            if(withdrawaccount.getBalance() < money){
                System.out.println("결과 : 잔액이 부족합니다.");
                return;
            }

            withdrawaccount.setBalance(withdrawaccount.getBalance() - money);
            depositaccount.setBalance(depositaccount.getBalance() + money);
            System.out.printf("%s 계좌로 %d원 이체되었습니다.", depositaccount, money);
            // 현재의 잔액을 gatter로 불러와서 예금액(money)를 더한 후 setBalance로 뺸 금액을 넣어 출금액을 정하고
            // 새로운 계좌에 출금액을 더하기

        }

    }

