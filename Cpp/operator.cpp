#include<iostream>
using namespace std;

int main(){

   int a,b;
   cout<<"\nEnter value of A: ";
   cin>>a;
   cout<<"\nEnter value of B: ";
   cin>>b;


   cout<<"\n\n";
   cout<<"\ta&b: "<<(a&b)<<"\n";
   cout<<"\ta|b: "<<(a|b)<<"\n";
   cout<<"\t~a: "<<~a<<"\n";
   cout<<"\ta^b: "<<(a^b)<<"\n\n";
   
   return 0;
}