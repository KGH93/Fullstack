#include <IOstream>
using namespace std;

int main(){
    int a,b,c;
    int max;

    cout << "세 정수를 입력하시오\n";
    cin >> a>>b>>c;
    max = a;

    if( b > max){
        max = b;
    }if( max < c){
        max = c;
    }

    cout << "가캉 큰 수는 " << max << "입니다.";

    return 0;
    
}

//for문 스캔으로 배열5개 숫자받아서 배열안에서 제일 큰숫자 출력