#include <stdio.h>
//최소나이를 구하시오
int main(){
    int matrix[2][3] = {{1,4,2},{3,6,8}};
    int i, j;
    for( i = 0; i < 2; i++){
        for ( j = 0; j < 3; j++){
            printf("%d\n", matrix[i][j]);
        }
    }
    return 0 ;
}
