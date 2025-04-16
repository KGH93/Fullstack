#include <iostream>
#include <queue>
using namespace std;

int main(){
    queue<int> q;
    //FIFO(FIRS IN,FIRST OUT)
    //큐에 데이터 추가(push)
    q.push(10); 
    q.push(20); 
    q.push(30); 
    cout << "현재 큐의 맨 앞 값 : " << q.front() << endl; //10출력
    cout << "현재 큐의 맨 뒤 값 : " << q.back() << endl; //30출력

    //큐의 데이터 제거

    q.pop();
    cout << "pop이후 큐 맨 앞 값 : " << q.front() << endl; //20출력

    //큐 크기 확인
    cout << "현재 큐 크기: " << q.size() << endl;

    while (!q.empty()){
        cout << "큐에서 꺼낸 값: " << q.front() << endl;
        q.pop();
    }

    return 0;
}

// push() -> 값 넣기
// pop -> 큐에 데이터 제거 (앞쪽 요쇼제거)
// front() -> 맨앞 요소 확인
// back() -> 맨뒤 요소 확인
// empty() -> 큐가 비었는지 확인
// size() -> 현재 큐 크기 확인