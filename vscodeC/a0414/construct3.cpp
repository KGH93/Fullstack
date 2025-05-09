#include <IOstream>
#include <string>
using namespace std;
//함수와 마찬가지로 생성자도 클래스 외부에서 정의 할 수 있습니다. 먼저 클래스 내부에 생성자를 선언한 뒤,
//클래스명, 범위결정 :: 연선자, 생성자이름(클래스 이름과 동일)을 차례로 지정
class Car{
    public:
        string brand;
        string model;
        int year;
        Car(string x,string y, int z);
};
        Car::Car(string x,string y, int z){
            brand = x;
            model = y;
            year = z;
        };

int main(){
    Car carObj1("BMW","X5",1999);
    Car carObj2("FORD","MUSTANG",1969);
    cout << carObj1.brand << " " << carObj1.model << " " << carObj1.year << "\n";
    cout << carObj2.brand << " " << carObj2.model << " " << carObj2.year << "\n";

    return 0;
}

