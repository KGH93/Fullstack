#include <stdio.h>


int main(){

    int a;
    int b;
    char z;
    double result;
    // Calculater cals();

    printf("정수 두개를 입력해주세요. :");
    scanf("%d %d",&a,&b);
    printf("연산자를 입력해주세요. (+,-,*,%%,/):");
    scanf(" %c",&z);

   
    switch (z)
        {
        case '+':
            result = a+b;
            break;
        case '-':
            result = a-b;
            break;
        case '*':
            result = a*b;
            break;
        case '%':
            result = a%b;
            break;
        case '/':
            if(b!=0){
                result = (double)(a)/b;
            }else{
                printf("0입력으로 인한 오류입니다.");
            }
            break;
        default:
            printf("잘못입력하셨습니다.");
        }
    printf("%d와 %d의 %c 값은 %.f 입니다.",a,b,z,result);
    

    return 0;
}