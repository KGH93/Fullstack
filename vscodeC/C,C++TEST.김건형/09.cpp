#include <iostream>
#include <string>
using namespace std;


class Animal{
    public:
        void sound(){
            cout << "AnimalSound is here\n";
        }
};


class Dog :public Animal{
    public:
        void sound(){
            cout << "DogSound is 멍멍!\n";
        }
};


int main() {
    Animal myanimal;
    Dog mydog;

    myanimal.sound();
    mydog.sound();

    return 0;
}