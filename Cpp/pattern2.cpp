#include<iostream>
using namespace std;

int main(){

    int n;
    cout<<"Enter length of pattern: ";
    cin>>n;
    cout<<"\n";

    int i=1;
    while (i<=n)
    {
        int j=1;
        while (j<=i)
        {
            cout<<"*"<<" ";
            j+=1;
        }
        cout<<endl;
        i+=1;
    }

    cout<<"\n\n";
    i=1;
    while (i<=n)
    {
        int j=i;
        while (j<=n)
        {
            cout<<"*"<<" ";
            j+=1;
        }
        cout<<endl;
        i+=1;
    }
    return 0;
}