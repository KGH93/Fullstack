#include <stdio.h>

main (){
    char carName[] = "Volvo";   // 문자열을 문자배열로 저장
    int length = sizeof(carName) / sizeof(carName[0]);
    // 문자 하나당 4byte  전체 바이트 수는 20byte   20/4 = 5
    int i;
    for(i=0;i<length;i++)
    printf("%c\n", carName[i]); //문자열 출력

    return 0;
}