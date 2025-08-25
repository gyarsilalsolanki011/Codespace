#include<iostream>
using namespace std;
int Unique(int arr[], int N);

int main()
{
    cout << "\tWelcome To XOR\n" << endl;
    int arr[5]={4,5,3,5,4};
    int Un = Unique(arr, 5);
    
    cout <<"\n\t4^5^3^5^4 = "<< (4^5^3^5^4) << endl;
    cout << "\tUnique is: " << Un << endl;
    return 0;
}

int Unique(int *arr, int n){
   int ans = 0,a;
   for(int i=0; i<n; i++){
       a = ans;
       ans = ans^arr[i];
       cout <<"\t"<<a<<"^"<<arr[i]<<" = "<< ans << endl;
   }
   return ans;
}