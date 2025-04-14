#include <IOstream>
#include <string>
using namespace std;

class Vehicle{
    public:
        string brand = "FORD";
        void honk(){
            cout << "Tuut, Tuut! \n";
        }
};
class Car: public Vehicle{
    public:
        string model = "Mustang"; 
};

int main(){
    Car myCar;
    myCar.honk();
    cout << myCar.brand + " " + myCar.model;
    return 0;
}

