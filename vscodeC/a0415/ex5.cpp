#include <iostream>
#include <vector>
using namespace std;

// 사용자로부터 정수 5개를 입력받아 vector<int> 에 저장한 후,
// 저장된 값을 모두 출력하는 프로그램을 작성하세요
vector<int> vec;
int num;

int main() {
    cout << "정수 5개를 입력하시오" << "\n";
    
    for(int i = 0; i < 5 ; i ++){
        cin >> num;
        vec.push_back(num);
    }

    for(int i = 0; i < 5 ; i ++){
        cout << vec[i] << "\n";
    }

    return 0;
}