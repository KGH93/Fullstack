#include <stdio.h>

int main(){
    int a,b,c;
    int max;

    printf("세 정수를 입력하시오\n");
    scanf("%d %d %d",&a,&b,&c);
    max = a;

    if( b > max){
        max = b;
    }if( max < c){
        max = c;
    }

    printf("가캉 큰 수는 %d 입니다.\n", max);

    return 0;
    
}