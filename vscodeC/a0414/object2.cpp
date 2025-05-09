#include <IOstream>
#include <string>
using namespace std;

class Car{
    public:
        string brand;
        string model;
        int year;
};

int main(){
    Car carobj1;
    carobj1.brand = "BMW";
    carobj1.model = "X5";
    carobj1.year = 1999;
    Car carobj2;
    carobj2.brand = "FORD";
    carobj2.model = "MUSTANG";
    carobj2.year = 1969;

    cout << carobj1.brand << " " << carobj1.model << " " << carobj1.year << "\n";
    cout << carobj2.brand << " " << carobj2.model << " " << carobj2.year << "\n";


    return 0;
}

