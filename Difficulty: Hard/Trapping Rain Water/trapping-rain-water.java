//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n=arr.length;
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(arr[max]<arr[i])
            max=i;
        }
        int water=0;
        int left_max=0;
        for(int i=0;i<max;i++)
        {
            if(arr[i]>left_max)
            left_max=arr[i];
            
            water=water+(left_max-arr[i]);
        }
         int right_max=0;
        for(int i=n-1;i>max;i--)
        {
            if(arr[i]>right_max)
            right_max=arr[i];
            water=water+(right_max-arr[i]);
        }
        return water;
    }
}
