#include<iostream>
using namespace std;

//prototype declaration
int ArraySearch(int A[], int n);

int main(){

    int n;
    cout<<"\nEnter size of N: ";
    cin>>n;

    int A[n];
    cout<<"\nEnter Elements of Array:\n";
    for (int i = 0; i <= n-1; i++)
    {
        cin>>A[i];
    }
    int num = ArraySearch(A, n);
    cout<<"\nElement Note found in Array: "<<num<<endl;

    return 0;
}
    
  //External Function whose prototype declared above
   int ArraySearch(int A[], int n){

    for (int i = 1; i <= n; i++)
    {   
        int temp=0,j=0;
        for (; j <= n-1; j++)
        {

            if(A[j] == i){
                temp = 1;
            }
        }
        if (temp == 0)
        {
           return i;
            break;
        }  
    }
   }


