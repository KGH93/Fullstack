#include <stdio.h>

int main(){
    int myNumbers[] = {10,25,50,75,100};

    printf("%lu",sizeof(myNumbers));   //20
    // lu = unsigned Long
    return 0;
}

// int 는 보통 4byte사용   4 * 배열5개 = 20