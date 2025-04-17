#include<IOstream>
#include<vector>
using namespace std;

int main(){
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};
    auto it = cars.begin()+2; //인덱스 2번위치(ford)
    cars.insert(it,"Hyundai"); //인덱스 3번째자리에 삽입

    for(string car : cars){
        cout << car << "\n";
    }

    return 0;    
}
