#include <stdio.h>

int main(){
    int num;
    int fac=1;

    printf("정수를 입력하시오.");
    scanf("%d",&num);

    for(int i = 1; i <= num; i++){
            fac *= i;
    }
    printf("%d의 팩토리얼값은 %d",num,fac);

    return 0;
}