//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int a =1;
        for(int i =0; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                
            a++;
        } else{
            if(a>(n/3)){
                list.add(nums[i]);
                a=1;
            }
            a=1;
        }
    }
    if(a>(n/3)){
        list.add(nums[n-1]);
        a=1;
    }
    return list;
    }
}