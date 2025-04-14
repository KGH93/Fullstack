#include <IOstream>
#include <string>
using namespace std;

class MyClass{
    public:
        void myMethod(){
        cout << "Hello World";
        }
};

int main(){
    MyClass myobj;
    myobj.myMethod();

    return 0;
}

