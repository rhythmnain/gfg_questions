class Solution {
  public:
    int catchThieves(vector<char> &arr, int k) {
        // Code here
        int n=arr.size();
        int p=0,t=0,cnt=0;
        while(p<n && t<n){
            while(p<n && arr[p]!='P') p++;
            while(t<n && arr[t]!='T') t++;
            if(p<n && t<n){
                if(p-t>k){
                    t++;
                } else if(t-p>k) {
                    p++;
                } else {
                    t++,p++;
                    cnt++;
                }
            }
        }
        return cnt;
    }
};