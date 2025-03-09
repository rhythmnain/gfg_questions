//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countPS(String str) {
        // code here
        int ans=0,n=str.length(),goToLeft,goToRight;
        for(int i=0;i<n-1;i++){
            for(goToLeft=i,goToRight=i;goToLeft>-1&&goToRight<n&&str.charAt(goToLeft)==str.charAt(goToRight);goToLeft--,goToRight++){
                if(goToRight>goToLeft){
                    ans++;
                }
            }
            for(goToLeft=i,goToRight=i+1;goToLeft>-1&&goToRight<n&&str.charAt(goToLeft)==str.charAt(goToRight);goToLeft--,goToRight++){
                if(goToRight>goToLeft){
                    ans++;
                }
            }
        }
        return ans;
    }
}