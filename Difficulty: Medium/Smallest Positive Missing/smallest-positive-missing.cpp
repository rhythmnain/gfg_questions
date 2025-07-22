class Solution {
  public:
    int missingNumber(vector<int> &arr) {
        // code here
         sort(arr.begin(),arr.end());
        int missing = 1;
        for(int i = 0;i<arr.size();i++){
            if(arr[i]<missing){
                continue;
            }
            if(arr[i]==missing){
                missing++;
            }
            else if(arr[i] > missing) {
                return missing;
            }
        }
        return missing;
    }
};