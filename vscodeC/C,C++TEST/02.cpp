#include <stdio.h>

int main (){

    int num;


    printf("정수를 입력해주세요. :");
    scanf("%d",&num);

        if(num%2 ==0){
            printf("%d는 짝수입니다.",num);
        }else if(num%2 == 1){
            printf("%d는 홀수입니다.",num);
        }else{
            printf("잘못된 입력입니다. 정수를 입력해주세요.");
        }

    return 0;
}
