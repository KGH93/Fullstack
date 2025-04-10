#include <stdio.h>

int main(){
    FILE *fptr;   //기본적인 데이터 유형, 사용하려면 포인터 변수 fptr

    fptr = fopen("d:\\ticket\\filename.txt", "r");
    char myString[100];
    fgets(myString,100,fptr)
    //myString -방금만들 배열에 저장
    //100 -myString(100)과 일치
    // fptr 파일을 읽는데 사용되는 파일 포인터
    printf("%s", myString);


    fclose(fptr);
    return 0;
}