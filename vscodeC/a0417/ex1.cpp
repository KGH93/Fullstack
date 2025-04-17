#include <stdio.h>

// 문제 1: 정수의 자릿수 합 구하기

// 사용자로부터 양의 정수를 입력받아 각 자릿수의 합을 계산하여 출력하는 프로그램을 작성하세요. 예를 들어, 입력이 12345라면 출력은 1 + 2 + 3 + 4 + 5 = 15가 되어야 합니다.

int main() {
    int n;
    int result;

    printf("양의 정수를 입력해주세요.");
    scanf("%d",&n);
    printf("%d",n);

    if(n<0){
        printf("양의 정수를 입력해주세요\n");
        return 1;
    }
    while (n>0)
    {
        result = result + (n % 10);
        n = n / 10;
    }

    printf("결과는 %d",result);

    return 0;
}