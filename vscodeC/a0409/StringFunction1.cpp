#include <stdio.h>
#include <string.h>

main (){
    char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    printf("%d\n",strlen(alphabet));  //26
    printf("%d\n",sizeof(alphabet));  //27   \0 null문자 포함
    return 0;
}