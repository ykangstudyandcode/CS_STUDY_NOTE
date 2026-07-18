#include<iostream>
#include<string>
using namespace std;

struct VendMachine{
    int id;
    string name;
    float price;
};


int main(){
    
    cout<<"Please enter a number you want to build "<<endl;
    int size;
    cin>>size;

    VendMachine* VM = new VendMachine[size];
    VendMachine* ptr = &VM[0];

    cout<<"Please enter the id, name and price of the vending machine "<<endl;

    for(int i = 0; i < size;i++){

        int id_vm;
        cin >> id_vm;
        (ptr+i)->id = id_vm;

        string name_vm;
        cin >> name_vm;
        (ptr+i)->name = name_vm;

        float price_vm;
        cin >> price_vm;
        (ptr+i)->price = price_vm;

        if(i == size-1){
            
            cout<<"The vending machine you entered is "<<endl;
            for(int j = 0; j < size;j++){
                cout<<"ID: "<<(ptr+j)->id<<endl;
                cout<<"Name: "<<(ptr+j)->name<<endl;
                cout<<"Price: "<<(ptr+j)->price<<endl;
            };
        };
    }; 

    delete[] VM;
    ptr = nullptr;
    VM = nullptr;
}