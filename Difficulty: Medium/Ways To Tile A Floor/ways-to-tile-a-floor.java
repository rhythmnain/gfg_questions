class Solution {
    public int tile(int n,int[] dp){
        if(n==1) return 1;
        if(n==2) return 2;
        
        
        if(dp[n]!=-1) return dp[n];
        
        
        return dp[n]=tile(n-1,dp)+tile(n-2,dp);
    }
    public int numberOfWays(int n) {
        
        
        Solution s=new Solution();
        
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return s.tile(n,dp);
    }
};