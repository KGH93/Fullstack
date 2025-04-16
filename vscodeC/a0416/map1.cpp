#include <iostream>
#include <map>
using namespace std;

int main(){
    // map 선언
    map<string, int> score;
    
    //값을 삽입
    score["Alice"] = 95;
    score["Bob"] = 82;
    score["Charlie"] = 88;

    // 출력
    cout << "학생 점수 목록: " << endl;
    for(map<string, int>::iterator it = score.begin(); it != score.end(); ++it){
        cout << it -> first << " : " << it -> second << endl;}
        // it -> first = 학생이름 , it -> second = 점수


    for(auto it=score.begin(); it != score.end();++it){
        cout << it -> first << " : " << it -> second << endl;
    }
    // it -> first 키
    // it -> second 값


    // 특정값 찾기
    string name = "Bob";
    if(score.find(name) != score.end()){
        cout << name << "의 점수는 " << score[name] << "점 입니다." << endl;
    }else{
        cout << name << "의 점수가 존재하지 않습니다." << endl;
    }


    //삭제
    score.erase("Charlie");
    cout << "삭제 후 남은 학생 목록" << endl;
    for(const auto& pair : score){
        cout << pair.first << " : " << pair.second << endl;
    }
    // const auto& pair : score - score라는 map의 각 key=value 쌍을 pair 라는 이름으로 하나씩 가져옴
    // :score = score 대상으로 순회 하겠다.
    // pair.first - 현재 순회중인 key
    // pair.second - 현재 순회중인 value

    return 0;
}

