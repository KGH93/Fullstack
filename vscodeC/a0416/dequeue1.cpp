#include <iostream>
#include <deque>
using namespace std;

int main(){
    deque<int> dq;
    
    dq.push_back(10); //뒤에 10추가 
    dq.push_back(20); //뒤에 20추가
    dq.push_front(5); //앞에 5추가
    cout << "현재 데큐의 맨 앞 값 : " << dq.front() << endl; //5출력
    cout << "현재 데큐의 맨 뒤 값 : " << dq.back() << endl; //20출력

    //디큐의 데이터 제거
    dq.pop_front(); //5제거
    dq.pop_back(); //20제거

    cout << "삭제이후 데큐 맨 앞 값 : " << dq.front() << endl; //10출력

    dq.push_back(30);  
    dq.push_front(1);

    //큐 크기 확인
    cout << "현재 데큐 요소들: ";
        for(int num : dq){
            cout << num << " ";
        }
    cout << endl;

    return 0;
}

// push_back() -> 뒤에삽입
// push_front() -> 앞에삽입
// pop_back() -> 뒤에제거
// pop_front() -> 앞에제거
// front() -> 맨앞 요소 확인
// back() -> 맨뒤 요소 확인
// size() -> 크기 확인
// empty() -> 비어있는지 확인