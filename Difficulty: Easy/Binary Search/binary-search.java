class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int l =0;
        int h = n-1;
        int res = -1;
        
        while(l<=h){
            int mid =(l+h)/2;
            
            if(arr[mid]==k){
                res = mid;
                h=mid-1;
            }
            else if(k<arr[mid]){
                h= mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
}