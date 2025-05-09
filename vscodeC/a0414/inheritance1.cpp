#include <IOstream>
#include <string>
using namespace std;

class MyClass{
    public:
        void myFunction(){
            cout << "Some Content in parent class";
        }
};

class MYChild: public MyClass{
};
class MYGrandChild: public MYChild{
};

int main(){
    MYGrandChild myObj;
    myObj.myFunction();

    return 0;
}

