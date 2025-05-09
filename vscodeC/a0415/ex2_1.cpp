#include <IOstream>
#include <string>
using namespace std;


// 멤버 클래스를 만들고 출력하시오

class Member{
    public:
        string name;
        string sex;
        int age;
};

int main(){
    Member mb1;
    mb1.name = "Park";
    mb1.sex = "male";
    mb1.age = 29;
    Member mb2;
    mb2.name = "Kim";
    mb2.sex = "female";
    mb2.age = 30;

    cout << mb1.name << " " << mb1.sex << " " << mb1.age << "\n";
    cout << mb2.name << " " << mb2.sex << " " << mb2.age << "\n";


    return 0;
}

