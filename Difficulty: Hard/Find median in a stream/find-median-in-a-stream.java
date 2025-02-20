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
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
     PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    ArrayList<Double> ans;
    public ArrayList<Double> getMedian(int[] arr) {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
        ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            add(arr[i]);
        }
        return ans;
    }
    public void add(int num){
        if(maxheap.size()==0) maxheap.add(num);
        else{
            if(num<maxheap.peek()) maxheap.add(num);
            else minheap.add(num);
        }
        
        if(maxheap.size()==minheap.size()+2){
            int top = maxheap.remove();
            minheap.add(top);
        }
        if(minheap.size()==maxheap.size()+2){
            int top = minheap.remove();
            maxheap.add(top);
        }
        
        if(maxheap.size()==minheap.size()) ans.add((maxheap.peek()+minheap.peek())/2.0);
        else if(maxheap.size()>minheap.size()) ans.add(maxheap.peek()*1.0);
        else ans.add(minheap.peek()*1.0);
    //public ArrayList<Double> getMedian(int[] arr) {
        // code here
    }
}