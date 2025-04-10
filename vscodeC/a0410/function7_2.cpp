#include <stdio.h>
int x = 5;  //전역변수
void myFunction(){
    printf("%d", x);  
}

int main(){
    myFunction();
    printf("%d", x);  
    return 0;
}