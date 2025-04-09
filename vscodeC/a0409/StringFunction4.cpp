#include <stdio.h>
#include <string.h>

main (){
    char str1[20] = "Hello ";
    char str2[] = "world";
    strcat(str2, str1);  //  str1을 str2에 붙임 
    printf("%s\n",str2); // 출력 hello world!

    return 0;
}