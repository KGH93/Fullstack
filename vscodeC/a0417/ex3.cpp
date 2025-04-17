#include <stdio.h>
#include <string.h>

// 문제 3: 문자열 뒤집기

// 사용자로부터 문자열을 입력받아 그 문자열을 뒤집어서 출력하는 프로그램을 작성하세요. 

// 예를 들어, 입력이 "hello"라면 출력은 "olleh"가 되어야 합니다. (힌트: 문자열의 길이를 구하고 배열의 인덱스를 활용하세요.)

int main(){
    char str[100];
    int length;
    char temp;
    printf("문자열을 입력하세요: ");
    scanf("%s",str); //공백없는 문자열 입력 가정
    length = strlen(str);  // <string.h> 필요 // strlen 문자의 갯수를 알아보는 메서드
    printf("문자갯수: %d\n",length);

    // 양쪽끝에서 가운데로 이동하며 문자 교환
    for(int i=0; i < length /2 ; i++){
        temp = str[i];
        str[i] = str[length-1-i];
        str[length-1-i] = temp;
    }
    printf("뒤집어진 문자열: %s\n",str);

    return 0;
}