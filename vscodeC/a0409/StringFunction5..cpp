#include <stdio.h>
#include <string.h>

main (){
    char str1[] = "Hello ";
    char str2[] = "Hello";
    char str3[] = "Hi";
    printf("%d\n",strcmp(str1, str2)); // 출력0
    printf("%d\n",strcmp(str1, str3)); // 다르면 음수 출력

    return 0;
}