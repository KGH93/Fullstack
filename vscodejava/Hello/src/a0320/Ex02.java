package a0320;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        boolean run =true;
        int student = 0;
        int[] score = null;

        Scanner scan = new Scanner(System.in);

        while (run) {
            System.out.println("=====================================================");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4. 분석 | 5.종료");
            System.out.println("=====================================================");
            System.out.print("선택>");

            int seletNo = Integer.parseInt(scan.nextLine());

            if(seletNo==1){
                System.out.println("학생수>");
                student = Integer.parseInt(scan.nextLine());
                score = new int[student];
            }else if(seletNo==2){
                for(int i = 0; i < score.length; i++){
                    System.out.print("score[" + i + "]>");
                    score[i] = Integer.parseInt(scan.nextLine());
                }
            }
                else if(seletNo==3){
                    for(int i = 0; i < score.length; i++){
                        System.out.print("score[" + i + "]:" + score[i]+"");
                }
            }
                else if(seletNo==4){
                    int max = 0;
                    int sum = 0;
                    double avg = 0;
                    for(int i = 0; i<score.length; i++){
                        max = ( max < score[i] ) ? score[i] : max;
                        sum += score[i];
                    }
                    avg = (double)sum / student;
                    System.out.println("최고점수 : " + max);
                    System.out.println("평균점수 : " + avg);
                }
                else if(seletNo==5){
                    run = false;
                }
            }
            System.out.println("프로그램 종료");
        }
    }

