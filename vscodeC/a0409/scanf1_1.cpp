#include <stdio.h>

main (){
    int myNum;
    char myChar;
    printf("Type a number and a character and press enter: \n");
    scanf("%d %c", &myNum, &myChar);   //&주소를 통해 값을 저장
    printf("Your number is : %d\n", myNum);
    printf("Your character is : %c\n", myChar);
    return 0;
}

// %d 정수 입력 = 변수 int
// %f 실수 입력 = 변수타입 float
// %lf 실수 입력 = double
// %s 문자열 입력 = char[]
// %c 문자 입력 = char