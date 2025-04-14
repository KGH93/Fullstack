#include <IOstream>
#include <string>
using namespace std;

// ✅ 문제 2⃣
// Car 클래스를 만들고

// modelName과 speed 속성,

// speedUp() / speedDown() 함수를 만들어 속도를 조절하세요.


class Car{
    private:
        string modelName;
        int speed;
    public:
        Car(string name){
            modelName = name;
            speed = 0;
        }
    void speedUp(int p){
        speed += p;
        cout << p << "km/h increase " << " NowSpeed " << speed <<"km/h\n";
    }
    void speedDown(int m){
        speed -= m;
        cout << m << "km/h discrease " << " NowSpeed " << speed <<"km/h\n"; 
    }
};

int main(){
    Car myCar("Audi");
    myCar.speedUp(200);
    myCar.speedDown(100);

    return 0;
}

