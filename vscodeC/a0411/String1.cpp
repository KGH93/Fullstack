#include <iostream>
#include <string>
using namespace std;

int main(){
    int myNum = 5;;
    float myFloatNum = 5.99;     //Floating point number
    double myDoubleNum = 9.98;   //Floating point number
    char myLetter = 'D';         //Character
    bool myBoolean = true;       //Boolean
    
    string myString = "Hello";

    cout << "int: " << myNum << "\n";
    cout << "float: " << myFloatNum << "\n";
    cout << "double: " << myDoubleNum << "\n";
    cout << "char: " << myLetter << "\n";
    cout << "bool: " << myBoolean << "\n";
    cout << "string: " << myString << "\n";

    return 0;
}