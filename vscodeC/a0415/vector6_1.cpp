#include<IOstream>
#include<vector>
using namespace std;

int main(){
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};
    cars.pop_back();  //벡터요소의 제거

    for(string car : cars){
        cout << car << "\n";
    }

    cout << cars.size()<<"\n"; //vector의 크기
    cout << cars.empty();   // 비어있으면 true라서 1, 차있으므로 0
   
    return 0;    
}
