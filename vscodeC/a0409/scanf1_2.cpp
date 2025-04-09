#include <stdio.h>

main (){
    // Create a string
  char firstName[30];

  // Ask the user to input some text (name)
  printf("Enter your first name and press enter: \n");

  // Get and save the text
  scanf("%s", firstName);  //배열이름은 배열자체가 주소이므로 &필요 없음

  // Output the text
  printf("Hello %s", firstName);
  
  return 0;
}

// %d 정수 입력 = 변수 int
// %f 실수 입력 = 변수타입 float
// %lf 실수 입력 = double
// %s 문자열 입력 = char[]
// %c 문자 입력 = char