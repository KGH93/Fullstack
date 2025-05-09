#include<IOstream>
#include<vector>
using namespace std;

int main(){
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

        cout << cars.at(1) << "\n"; //첫번째요소에서 +1칸접근
        cout << cars.at(2) << "\n"; //첫번쨰요소에서 +2칸접근
        // cout << cars.at(6) << "\n";  // 오류가 있을때 이를 알려줌    

    return 0;    
}
