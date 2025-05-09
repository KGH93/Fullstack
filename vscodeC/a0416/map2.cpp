#include <iostream>
#include <map>
using namespace std;

int main(){
    // map 선언
    map<string, int> payment;
    
    //값을 삽입
    payment["Kim"] = 4500;
    payment["Lee"] = 5200;
    payment["Park"] = 4800;
    payment["Choi"] = 5500;
    payment["Jung"] = 6100;

    // 출력
    cout << "연봉 5000이상 직원 목록: " << endl;
        for(auto it=payment.begin(); it != payment.end(); ++it){
            if(it->second >= 5000){
            cout << it->first << " : " << it->second << endl;
            }
        }
    return 0;
}

