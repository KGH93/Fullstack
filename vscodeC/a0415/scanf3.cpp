#include <stdio.h>

int main(){
    int a,b,c;

    printf("세 정수를 입력하시오\n");
    scanf("%d %d %d",&a,&b,&c);

    if( a> b && a > c){
        printf("%d가 제일 큰수",a);
    }else if ( a < c){
        printf("%d가 제일 큰수",c);
    }else{
        printf("%d가 제일 큰수",b);
    }

    return 0;
}