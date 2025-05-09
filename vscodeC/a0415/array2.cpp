#include <IOstream>
using namespace std;

int main(){
    int arr[5];
    int max;

   cout << "다섯 정수를 입력하시오\n";
    
    for ( int i = 0; i < 5; i++){
        cin >> arr[i];
    }

    max = arr[0];

    for ( int i = 0; i < 5; i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }

    cout << "가장 큰 값은 " << max << "입니다.\n";


    return 0;
}