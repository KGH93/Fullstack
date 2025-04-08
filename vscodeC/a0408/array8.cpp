#include <stdio.h>
//최소나이를 구하시오
int main(){
    int ages[] = {20,22,18,35,48,26,87,70};
    int min = 100;
    int i;
    int length = sizeof(ages) / sizeof(ages[0]);   //배열의 갯수
    for ( i = 0; i < length; i ++ ){
       if ( ages[i] < min){
            min = ages[i];
       }
    }
    

    // print the average
    printf("The Min age is: %d", min);
    return 0 ;
}
