#include <stdio.h>

int main(){
    int myNumbers[] = {10,25,50,75,100};
    int length = sizeof(myNumbers) / sizeof(myNumbers[0]);   //배열의 갯수
    printf("%d", length);   //20
    // lu = unsigned Long
    return 0;
}

// int 는 보통 4byte사용   4 * 배열5개 = 20