#include <iostream>

using namespace std;

// 문제 1: 클래스를 이용한 간단한 계산기 만들기

// 두 개의 정수 멤버 변수와 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 수행하는 멤버 함수를 가진 Calculator 클래스를 설계하고 구현하세요. 

// 메인 함수에서 Calculator 객체를 생성하고 사용자로부터 두 개의 정수와 수행할 연산을 입력받아 결과를 출력하는 프로그램을 작성하세요. 

// 나눗셈의 경우 0으로 나누는 경우를 처리해야 합니다.

class calculator{
    public:
        int a,b; 
        int sum;
        int sub;
        int mul;
        double div; 

        calculator(int a, int b){
            a = a;
            b = b;
            sum = a + b;
            sub = a - b;
            mul = a * b;
            if(b != 0){
                div = (double)(a / b);
            }else{
                cout << "0은 나누기 불가";
                div =0;
            }
        }
};

int main(){
    int x;
    int y;
    char z;
    cout << "정수 두개를 입력하세요\n";
    cin >> x >> y;
    cout << "연산자를 입력하세요(+,-,*,/)\n";
    cin >> z;

    calculator cal(x,y);
    double result = 0;
    
    switch (z)
    {
    case '+':
        result = cal.sum;
        break;
    case '-':
        result = cal.sub;
        break;
    case '*':
        result = cal.mul;
        break;
    case '/':
        result = cal.div;
        break;
    default:
        cerr << "잘못된 입력입니다." << endl;
    }

    cout << x << "," << y << "의 " << z << " 연산값은 " << result << " 입니다." << endl;

    return 0;
}