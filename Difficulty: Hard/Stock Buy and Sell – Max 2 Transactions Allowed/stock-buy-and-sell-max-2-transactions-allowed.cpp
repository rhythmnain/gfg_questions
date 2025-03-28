//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution
{
    public:
        //User function Template for C++
         int maxProfit(vector<int>&price){
            //Write your code here..
            int n=price.size();
            vector<int>temp(n,0);
            
            //first traversal was from right to left
            int maxi=price[n-1];
            for(int i=n-2;i>=0;i--){
                maxi=max(maxi, price[i]);
                temp[i]=max(temp[i+1], maxi-price[i]);
            }
            
            //second traversal
            int mini=price[0];
            for(int i=1;i<n;i++){
                mini=min(price[i],mini);
                temp[i]=max(temp[i-1], price[i]-mini+temp[i]);
            }
            
            return temp[n-1];
            //Write your code here..
        }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;

        // Read first array
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int res = ob.maxProfit(arr);

        cout << res << endl << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends