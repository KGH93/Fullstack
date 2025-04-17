#include <iostream>
#include <string>
using namespace std;


int main(){
    string name;
    int age;


    cout << "이름을 입력하세요. " << endl;
    cin >> name;
    
    cout << "나이를 입력하세요. " << endl;
    cin >> age;


    cout << name << "님은 " << age << "세입니다." << endl;

    return 0;
}