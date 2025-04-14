#include <IOstream>
#include <string>
using namespace std;

class MyClass{
    public:
        int x;
    private:
        int y;
};

int main(){
    MyClass myObj;
    myObj.x = 25;   //allowerd (public)
    // myObj.y = 50; //not allowerd (private)

    return 0;
}

