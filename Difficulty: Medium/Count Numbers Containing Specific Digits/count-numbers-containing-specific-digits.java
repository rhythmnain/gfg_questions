class Solution {
    public int countValid(int n, int[] arr) {
        // code here
         Set<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            set.add(arr[i]);
        }
        int total=9*(int)Math.pow(10,(n-1));
        int size=set.size();
        int rem=10-size;
        int sub=set.contains(0)?rem * (int)Math.pow(rem, n-1):((rem-1)*(int)Math.pow(rem,(n-1)));
        return total-sub;
    }
}