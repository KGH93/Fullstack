#include<IOstream>
#include<vector>
using namespace std;

int main(){
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

    cars[0] = "테슬라";
    cars.at(1) = "Hyundai";

        cout << cars[0] << "\n";
        cout << cars.at(1) << "\n"; 
   
    return 0;    
}
