#include <stdio.h>

int main (){

    int num[5];
    int max = num[0];
    printf("정수 5개를 입력하시오");

    for(int i = 0; i < 5; i++){
        scanf("%d",&num[i]);
    }
    for(int i = 0; i < 5; i++){
        if(max<num[i]){
            max = num[i];
        }
    }
    printf("배열 중 가장 큰값은 %d 입니다.",max);

    return 0;
}
