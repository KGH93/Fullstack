#include <iostream>
#include <string>
using namespace std;


class Student{
    public:
    string name;
    int studentID;

    Student(string n,int s){
        name =n;
        studentID = s;
    }
};


int main(){
    Student s1;
    cout << "이름을 입력하시오" << endl;
    cin >> s1.name >> endl;
    cout << "학번을 입력하시오" << endl;
    cin >> s1.studentID >> endl;

    cout << s1.name << s1.studentID << endl;


    return 0;
}
