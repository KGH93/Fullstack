#include<IOstream>
#include<vector>
using namespace std;

int main(){
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

        cout << cars.front() << "\n"; //첫번째요소접근
        cout << cars.back() << "\n"; //마지막요소접근
       

    return 0;    
}
