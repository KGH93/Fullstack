#include <stdio.h>
#include <string.h>

main (){
    char str1[20] = "Hello ";
    char str2[] = "world";
    strcat(str1, str2);  // str2를 str1에 붙임 
    printf("%s\n",str1); // 출력 hello world!

    return 0;
}