#include <stdio.h>
// #include <limits.h>  // INT_MIN,INT_MAX 사용가능

// 문제 2: 배열의 평균과 최대/최소값 찾기

// 크기가 10인 정수형 배열을 선언하고 임의의 값으로 초기화하세요. 그 후, 배열의 모든 요소의 평균, 최댓값, 최솟값을 계산하여 출력하는 프로그램을 작성하세요.


int arr[10] = {5, 12, 8, 3, 15, 7, 9, 20, 1, 18};
int max = arr[0]; // INT_MIN = -2147483648
int min = arr[0]; // INT_MAX = 2147483648
double sum;
double avg;

int main(){

    for(int i = 0; i <10 ; i++){
        if(arr[i] > max){
            max = arr[i];
        }else{
            max;
        }
    }
    printf("최대값은 %d\n",max);

    for(int i = 0; i <10 ; i++){
        if(arr[i] < min){
            min = arr[i];
        }else{
            min;
        }
    }
    printf("최소값은 %d\n",min);

    for(int i = 0; i <10 ; i++){
        sum += arr[i];
    }
    avg = sum / (sizeof(arr)/sizeof(arr[0]));
    printf("평균값은 %.2f\n",avg);

    return 0;
}