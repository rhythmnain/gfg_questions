class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        long sum = 0;
        long pre=s.charAt(0)-'0';
        
        sum = pre;
        for(int i=1; i<n; i++){
            int num = s.charAt(i)-'0';
            pre=(pre*10 + num*(i+1));
            sum+=pre;
        }
        return (int) sum;
    }
}