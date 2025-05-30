#include <iostream>

using namespace std;

// 문제 1: 클래스를 이용한 간단한 계산기 만들기

// 두 개의 정수 멤버 변수와 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 수행하는 멤버 함수를 가진 Calculator 클래스를 설계하고 구현하세요. 

// 메인 함수에서 Calculator 객체를 생성하고 사용자로부터 두 개의 정수와 수행할 연산을 입력받아 결과를 출력하는 프로그램을 작성하세요. 

// 나눗셈의 경우 0으로 나누는 경우를 처리해야 합니다.

class Calculator{
    public:
        int a,b; 

    void setNum(int n1, int n2){
        a = n1;
        b = n2;
    }
    int add(){
        return a + b;
    }
    int multiply(){
        return a - b;
    }
    int subtract(){
        return a * b;
    }
    double divide(){
        if(b==0){
            cerr << "Error: division by zere!" << endl;
            return 0.0;
        }
        // return (double)(a) / b;
        // static_cast<double> c언어 문법
        return static_cast<double>(a) / b;
    }
};

int main(){
    Calculator calc;
    int n1, n2;
    char operation;
    cout << "두개의 정수를 입력하세요: ";
    cin >> n1 >> n2;

    calc.setNum(n1,n2);

    cout << "수행할 연산을 입력하세요(+,-,*,/): ";
    cin >> operation;

    double result;

    switch (operation)
    {
    case '+':
        result = calc.add();
        break;
    case '-':
        result = calc.subtract();
        break;
    case '*':
        result = calc.multiply();
        break;
    case '/':
        result = calc.divide();
        break;
    default:
        cerr << "Error: Invalid operation!" << endl;
    }
    // cerr  c++에서 표준 에러 출력 시스템
    cout << "결과 : " << result << endl;

    return 0;
}