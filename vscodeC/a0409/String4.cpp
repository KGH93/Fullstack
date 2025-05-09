#include <stdio.h>

main (){
    char carName[] = "Volvo";   // 문자열을 문자배열로 저장
    int i;
    for(i=0;i<5;i++)
    printf("%c\n", carName[i]); //문자열 출력

    return 0;
}