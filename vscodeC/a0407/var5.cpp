#include <stdio.h>

int main () {
    int myNum = 15;
    int myOtherNum = 23;
    myNum = myOtherNum;

    printf("%d", myNum);  //23

    return 0;
}