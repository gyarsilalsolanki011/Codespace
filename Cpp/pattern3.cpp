#include<iostream>
using namespace std;

int main(){
  
     int n;
     cout<<"\nEnter the value of N: ";
     cin>>n;

     int row=1;
     while (row<=n)
     {
        //printing space triagle
        int space=n-row;
        while (space)
        {
            cout<<"  ";
            space-=1;
        }

        //print first triangle 
        int j=1;
        while (j<=row)        
        {
            cout<<j<<" ";
            j+=1;     
        }
        
        //print second triangle
        int start=row-1;
        while (start)
        {
            cout<<start<<" ";
            start-=1;
        }
        cout<<"\n";
        row+=1;
        
     }

     cout<<"\n\nNew pattern!\n\n"<<endl;

     int k=1;
     while (k<=n)
     {
        int space=n-k;
        while (space)
        {
           cout<<"  ";
           space-=1;
        }

        int start=k;
        while (start)
        {
            cout<<"* ";
            start-=1;
        }
        k+=1;
        cout<<endl;
    }
    return 0;
}