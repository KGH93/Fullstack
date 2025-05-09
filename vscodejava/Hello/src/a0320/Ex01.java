package a0320;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int student = 0;
        int[] score = null;

        while (run) {
            System.out.println("===================================================");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("===================================================");
            int choice = scan.nextInt();

            if (choice == 5) {
                System.out.println(">5.선택");
                System.out.println("프로그램 종료");
                run = false;
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("선택>1");
                    System.out.printf("학생 수를 입력해주세요 :");
                    student = scan.nextInt();
                    score = new int[student];
                    break;
                case 2:
                    if (score == null) {
                        System.out.println("먼저 학생수를 입력해주세요");
                    } else {
                        System.out.println("선택>2");
                        for (int i = 0; i < student; i++) {
                            System.out.println("학생들의 점수를 차례대로 입력해주세요: ");
                            score[i] = scan.nextInt();
                        }
                    }

                    break;
                case 3:
                    if (score == null) {
                        System.out.println("먼저 학생수를 입력해주세요");
                    } else {
                        System.out.println("선택>3");
                        for (int j = 0; j < student; j++) {
                            System.out.printf("score[%d]>%d%n", j, score[j]);
                        }
                        System.out.printf("학생수>%d", student);
                    }
                    break;
                case 4:
                    if (score == null) {
                        System.out.println("먼저 학생수를 입력해주세요");
                    } else {
                        System.out.println("선택>4");
                        int max = 0;
                        int sum = 0;
                        double avg = 0;
                        for (int i = 0; i < score.length; i++) {
                            max = (max < score[i]) ? score[i] : max;
                            sum += score[i];
                        }
                        avg = (double) sum / student;
                        System.out.println("최고 점수: " + max);
                        System.out.println("평균 점수: " + avg);
                    }
                    break;

                default:
                    System.out.println("잘못입력하셨습니다");
                    break;
            }
        }
        scan.close();
    }
}
