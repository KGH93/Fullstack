#include <IOstream>
#include <string>
using namespace std;


// 문제 1⃣
// Book 클래스를 만들어서

// 제목(title), 저자(author), 가격(price)를 저장하고,

// printInfo() 함수로 책 정보를 출력하세요.

class Book{
    private:
       string title;
       string author;
       int price;
    public:
        Book(string t,string a, int p){
            title = t;
            author = a;
            price = p;
        }
        Book(){}
        void printInfo(){
            cout << "타이틀: " << title << "\n";
            cout << "저자: " << author << "\n";
            cout << "가격: " << price << "원\n";
        };
        void printInfo2(string title,string author,int price){
            cout << "타이틀: " << title << "\n";
            cout << "저자: " << author << "\n";
            cout << "가격: " << price << "원\n";
        };

};

int main(){
   
    Book book("반지의 제왕","톨킨옹",25000);
    book.printInfo();

    Book books;
    books.printInfo2("해리포터","롤링",24000);
    
    return 0;
}

