#include <iostream>
#include <stack>
using namespace std;

int main(){
    stack<int> s;
    //LIFO(Last In,First Out) 
    //스택의 값을 넣기(push)
    s.push(10); 
    s.push(20); 
    s.push(30); 
    cout << "현재 스택의 맨 위 값 : " << s.top() << endl; //줄바꿈  //30출력

    //스택에서 값꺼내기
    s.pop();
    cout << "현재 스택의 맨 위 값 : " << s.top() << endl; //s.pop() 하나제거  //20출력

    //스택이 비었는지 확인
    if(!s.empty()){
        cout << "스택은 비어있지 않습니다." << endl;
    }

    //스택크기확인
    cout << "현재 스택의 크기 : " << s.size() << endl;

    //전체 스택 비우기
    while(!s.empty()){
        cout << "스택에서 꺼낸 값: " << s.top() << endl;
        s.pop();
    } 


    return 0;
}

// push() -> 값 넣기 -비커처럼 쌓이는 방식으로 저장
// pop -> 값 꺼내기 -맨 위부터 꺼냄
// top() -> 맨위 값확인
// empty() -> 스택이 비었는지 확인
// size() -> 현재 스택 크기 확인