#include<iostream>
using namespace std;

int main()
{
    int n;
    cout << "\nEnter Number of terms in Fabbo: ";
    cin >> n;
    
    int first = 0, Second = 1;
    int NextTerm = first + Second;
    
    cout << "\nRequire Fabonacci is: " << endl;
    cout << first <<" "<< Second <<" ";
    
    for(int i=2; i<n; i++){
        cout << NextTerm <<" ";
        first = Second;
        Second = NextTerm;
        NextTerm = first + Second;
        
    }
    cout << endl;
    return 0;
}