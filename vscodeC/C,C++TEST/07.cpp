#include <iostream>
#include <string>
using namespace std;


class Car{
    public:
    int speed;
    string color;

};


int main(){
    Car Ferrari;
    Ferrari.speed = 100;
    Ferrari.color = "Red";


    cout << "Ferrari의 속력은 " << Ferrari.speed << "km/s이고 색깔은 " << Ferrari.color << "이다." << endl; 

    return 0;
}
   