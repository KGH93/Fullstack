package a0331.book;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreService {

    private boolean reOrder = false;  //추가주문여부
    private int ordernum = 1;  //고객 번호
    Map<String,Integer> orderList;  //책이름, 수량

    
    public StoreService() {
        orderList = new LinkedHashMap<>();  //입력순서를 순서대로 저장하기위해서 사용
    }

    Book book = Book.getInstance();
    Customer customer;
    Thread t = new Thread();
    Scanner scan = new Scanner(System.in);


    public void start() {
        System.out.println("\n어서옵쇼 북스스토어입니다.");
        customer = new Customer(ordernum);
        book.getMenu();
        order();
        totalOrder(customer);
        try {
            System.out.println("기다려 주시면 주문하신 책이 결제됩니다.");
            Thread.sleep(2000);
            end();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void order() {
        System.out.println("\n 취소를 원하시면 0번을 눌러주세요.");
        end:while (true) {
            try {
                System.out.print("\n원하시는 책의 번호를 선택해주세요 ㅣ");
                int choice = scan.nextInt();
                if(choice == 0){
                    System.out.println("주문을 취소합니다.");
                    System.exit(0);
                }
                scan.nextLine();
                String bookName = book.bookList.get(choice-1);
                System.out.print("선택하신 책은 " + bookName + "입니다. 몇권 주문하십니까?");
                int orderCount = scan.nextInt();
                scan.nextLine();

                if(reOrder){
                    for(String bk : orderList.keySet()){
                        if (bk.equalsIgnoreCase(bookName)) {
                            int addCount = orderList.get(bk).intValue() + orderCount;
                            orderList.replace(bookName, addCount);
                        }else{
                            orderList.put(bookName,orderCount);
                            break;
                        }
                    }
                }else{
                    orderList.put(bookName, orderCount);
                }

                customer.setBookOrder(orderList);
                addOrder();
    
                break end;

            } catch (Exception e) {
                System.out.println("잘못된 선택입니다.");
                continue;
            }
        }
    }




    private void addOrder() {
        reOrder = false;
        System.out.println("\n주문을 계속하시겠습니까?");
        System.out.println("예(Y) / 아니오(N)");
        String yORn = scan.next();
        if(yORn.equals("예")|| yORn.equalsIgnoreCase("Y")){
            book.getMenu();
            reOrder = true;
            order();
        }else if(yORn.equals("아니오") || yORn.equalsIgnoreCase("N")){
            return;
        }
    }



    private void totalOrder(Customer customer) {
        int b = 1;
        int totalMoney = 0;
        int bookPrice = 0;
        double discount = 0;
        DecimalFormat f = new DecimalFormat("###,000원");
        String name = customer.getOrderName() + "번";
        StringBuffer message = new StringBuffer();
            message.append("\n\n ")
            .append("+----------------------------------------------------+\n ")
            .append("|                                                    | \n ")
            .append("|             " + name + "고객님 의 주문 내역 입니다         | " + "\n");
        
        for(Map.Entry<String,Integer> order : customer.getBookOrder().entrySet()){
            String bookName = order.getKey();
            int orderCount = order.getValue();
            int bookUnitPrice = book.menu.get(bookName);
            bookPrice = bookUnitPrice * orderCount;
            totalMoney = totalMoney + bookPrice;
            String pay = f.format(bookPrice);
            message.append(String.format(" | [%d] %-20s : %2d권  %7s |\n", b, bookName, orderCount, pay));
            b++;
        }
        
        if (totalMoney >= 10000) {
            System.out.println("만원 이상 구매시 10% 할인 혜택이 있습니다.");
            discount = 0.1 * totalMoney;
            totalMoney -= discount;
            System.out.printf("고객님의 주문 금액은 %.0f원이며 10,000원이상 구매시 10%%할인 혜택이 있습니다. 할인받으신 가격은 %.0f원입니다.", totalMoney+discount,discount);
        }
        message.append(" |                                                    |\n ")


        .append("+----------------------------------------------------+ \n")
        .append(" ============    할인 금액은 " + f.format(discount) + "입니다  ========== \n")
        .append(" ============ 총 결제 금액은 " + f.format(totalMoney) + "입니다 ========== \n");
        System.out.println(message);
        payment(totalMoney);

    }


   

    
    private void payment(int totalMoney) {
        System.out.println("\n결제합니다. 카드를 넣어주세요.");
        int payResult = customer.getMoney() - totalMoney;
        try {
            Thread.sleep(2500);
            System.out.println("결제중입니다......");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(payResult < 0){
            System.out.println("잔액이 부족합니다. 확인 후 다시 주문해주세요.");
        }else{
            customer.setMoney(payResult);
            System.out.println("결제가 완료되었습니다.");
            System.out.println("이용해주셔서 감사합니다.");
            ordernum++;
        }
    }


    private void end() {
        int b = 1;
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                    .append("+----------------------------------------------------+\n ")
                    .append("|                                                    | \n ")
                    .append("|           " + customer.getOrderName() + " 고객님 주문하신 책 출고되었습니다         | " + "\n");
                    System.out.print(message);
                for(Map.Entry<String,Integer>order:customer.getBookOrder().entrySet()){
                    System.out.printf(" | [%d] %-20s : %2d권  %7s |\n", b, order.getKey(), order.getValue(),"");
                    b++;
                    System.out.println(" |                                                    |");
                    System.out.println(" +----------------------------------------------------+");
                }

    }

}
