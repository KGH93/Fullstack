#include <stdio.h>

// 정수 n을 입력받아 n!(팩토리얼)을 구하시오

int n;
int fac =1;

int main (){
    printf("정수를 입력하세요.");
    scanf("%d",&n);


    for(int i = 1; i <= n; i++){
            fac*= i;
    }
    
    printf("%d의 팩토리얼: %d",n,fac);
    return 0;
}
