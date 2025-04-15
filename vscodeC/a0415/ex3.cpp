#include <IOstream>
#include <string>
using namespace std;


// 멤버 클래스를 만들고 출력하시오

class Member{
    public:
        string name;
        string sex;
        int age;
        Member(string n,string s,int a){
            name = n;
            sex = s;
            age = a;
        }
};

int main(){
    Member mb1("Park","female",29);
    
    Member mb2("Kim","male",30);
    

    cout << mb1.name << " " << mb1.sex << " " << mb1.age << "\n";
    cout << mb2.name << " " << mb2.sex << " " << mb2.age << "\n";


    return 0;
}

