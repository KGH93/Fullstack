#include <stdio.h>

int main(){
    const int myNum = 15;
    // myNum = 10; 재할당 불가능

    // const int minutesPerHour;
    // minutesPerHour = 60;
    const int minutesPerHour = 60;   //상수(const)는 선언과 함께 초기화
    printf("%d", myNum);
    return 0;
}