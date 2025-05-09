#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Book{
    string title;
    bool isBorrowed;

    public:
    Book(string t, bool b){
        title = t;
        isBorrowed = b;
    }    

    Book(string t){
        title = t;
        isBorrowed = false;
    }

    void print(){
        cout << title << (isBorrowed ? " (대출중)" : " (대출가능)") << endl;
    }

    void borrowBook(){
        isBorrowed = true;
    }

    void returnBook(){
        isBorrowed = false;
    }

    bool checkborrow(){
        return isBorrowed;   
    }

    string gettitle(){
        return title;
    }
};


int main(){
    vector<Book> library;
    library.push_back(Book("C++ 입문서"));
    library.push_back(Book("자료구조론"));
    library.push_back(Book("알고리즘 기초"));


    int choice;

    while (true) {
        cout << "=== 도서 대출 프로그램 ===\n";
        cout << "1. 도서 목록 확인\n";
        cout << "2. 도서 대출\n";
        cout << "3. 도서 반납\n";
        cout << "4. 프로그램 종료\n";
        cin >> choice;

        if (choice == 1){
            cout << "메뉴 선택: 1\n";
            for(int i = 0; i < library.size(); i ++){
                cout << (i+1) << ". ";
                library[i].print();
            }
        }else if (choice == 2){
            int pickNum;
            cout << "대출할 도서 번호를 입력하세요: \n";
            cin >> pickNum;
                if(pickNum>0 && pickNum <= library.size()){
                    if(!library[pickNum-1].checkborrow()){
                        library[pickNum-1].borrowBook();
                        cout << library[pickNum-1].gettitle() <<"의 대출이 완료되었습니다.\n";
                        library[pickNum-1].print();
                    }else{
                        cout << "이미 대출중인 도서입니다.\n";
                    }
                }else{
                    cout << "잘못된 도서 번호입니다.\n";
                }
        }else if (choice == 3){
            int returnNum;
            cout << "반납할 도서 번호를 입력하세요: \n";
            cin >> returnNum;
                if(returnNum>0 && returnNum <= library.size()){
                    if(library[returnNum-1].checkborrow()){
                        library[returnNum-1].returnBook();
                        cout << library[returnNum-1].gettitle() <<"의 반납이 완료되었습니다.\n";
                    }else{
                        cout << "잘못된 도서 번호입니다.\n";
                    }
                }else{
                    cout << "잘못된 도서 번호입니다.\n";
                }
        }else if (choice == 4){
            cout << "프로그램을 종료합니다!\n";
            break;
        } else{
            cout << "잘못된 선택입니다. 다시 입력하세요.\n\n";
        }
    }
    return 0;
}   
