#include <stdio.h>
int x = 5;  //전역변수
void myFunction(){
    int x = 22;  //x 재정의
    printf("%d\n", x);  
}

int main(){
    myFunction();
    printf("%d\n", x);  
    return 0;
}