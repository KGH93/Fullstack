#include <stdio.h>

int main(){
    int a,b,c;

    printf("세 정수를 입력하시오\n");
    scanf("%d %d %d",&a,&b,&c);
    
    int max = (a > b) ? a: b;
    max = (max > c) ? max : c;
    
    printf("가캉 큰 수는 %d 입니다.\n", max);

    return 0;
    
}