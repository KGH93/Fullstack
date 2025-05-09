#include <stdio.h>

main (){
    char greetings[] = "Hello World";   // 문자열을 문자배열로 저장
    greetings[0] = 'J';   //내용변경
    printf("%s", greetings); //문자열 출력

    return 0;
}