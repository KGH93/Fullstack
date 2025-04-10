#include <stdio.h>
// 재귀함수
int sum(int k);

int main(){
    int result = sum(10); 
    printf("%d\n", result);
    return 0;
}

int sum(int k){
    if(k>0){
        return k + sum(k-1);
    }else{
        return 0;
    }
}
//10 9 8 7 6 5 4 3 2 1 0