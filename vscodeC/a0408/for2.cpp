#include <stdio.h>

int main(){
    int i;
    int j;
    for( i = 0; i <= 2; i++){
        printf("Outer : %d\n",i);
        for( j = 0; j <= 3; j++){
            printf("Inner : %d\n",j);
        }
    }   
    return 0;
}