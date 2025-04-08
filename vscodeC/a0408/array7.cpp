#include <stdio.h>

int main(){
    int ages[] = {20,22,18,35,48,26,87,70};
    float avg, sum = 0;
    int i;
    int length = sizeof(ages) / sizeof(ages[0]);   //배열의 갯수
    for ( i = 0; i < length; i ++ ){
        sum += ages[i];
    }
    avg = sum / length;

    // print the average
    printf("The average age is: %.2f", avg);
    return 0 ;
}
