#include <IOstream>
#include <string>
using namespace std;

class Animal{
    public:
        void animalSound(){
            cout << "The animal make a sound \n";
        }
};

class Pig : public Animal{
    public:
        void animalSound(){
            cout << "The pig says : wee wee \n";
        }
};
class Dog : public Animal{
    public:
        void animalSound(){
            cout << "The Dog says : bow wow \n";
        }
};


int main(){
    Animal myAnimal;
    Pig myPig;
    Dog myDog;
 
    myAnimal.animalSound();
    myPig.animalSound();
    myDog.animalSound();

    return 0;
}

