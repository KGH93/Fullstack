#include <stdio.h>

// 문제 4: 구조체를 이용한 학생 정보 관리

// 다음과 같은 멤버를 갖는 Student 구조체를 정의하세요.

// name (문자열, 최대 20자)
// studentId (정수형)
// grade (문자형)
// 이후, Student 구조체 변수를 하나 선언하고 사용자로부터 이름, 학번, 학점을 입력받아 구조체 변수에 저장한 후, 저장된 정보를 출력하는 프로그램을 작성하세요.

struct Student{
    char name[20];
    int studentId;
    char grade;
};

int main(){
    struct Student s;

    printf("이름을 입력하세요(최대20자): ");
    scanf("%s",s.name); //배열명 자체가 주소이므로 &생략
    printf("학번을 입력하세요: ");
    scanf("%d",&s.studentId); //입력시 변수에 주소를 입력
    printf("학점을 입력하세요: ");
    scanf(" %c",&s.grade); //공백 문자를 처리해 scanf 오류 방지

    printf("\n--- 학생 정보 ---\n");
    printf("이름: %s\n", s.name);
    printf("학번: %d\n", s.studentId);
    printf("학점: %c\n", s.grade);

    return 0;
}