class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        int n= arr.length;
        ArrayList <Integer> ans= new ArrayList<>();
        int c= n/3, count=1;
        Arrays.sort(arr);
        for(int x=1;x<n;x++)
        {
            if(arr[x]!=arr[x-1])
            {
                if(count>c)
                    ans.add(arr[x-1]);
                count=1;
            }
            else
                count++;
        }
        if(count>c)
                    ans.add(arr[n-1]);
        
        return ans;
    }
}