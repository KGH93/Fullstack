#include <stdio.h>

int main () {
    int myNum = 15;
    int myOtherNum = 23;
    myOtherNum = myNum;

    printf("%d", myOtherNum);  //15

    return 0;
}