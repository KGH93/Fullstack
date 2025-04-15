#include <IOstream>
#include <string>
using namespace std;

class Animal{
   public:
        void animalSound(){
            cout << "동물소리\n";
        }
};

class Bird : public Animal{
    public:
        void animalSound(){
            cout << "새소리: 짹쨱\n";
        }
};
class Dog : public Animal{
    public:
        void animalSound(){
            cout << "개소리: 멍멍\n";
        }
};
class Fish : public Animal{
    public:
        void animalSound(){
            cout << "물고기: ...\n";
        }
};



int main(){
    Animal myAnimal;
    Bird myBird;
    Dog myDog;
    Fish myFish;

    myAnimal.animalSound();
    myBird.animalSound();
    myDog.animalSound();
    myFish.animalSound();

    return 0;
}

