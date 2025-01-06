//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int d = Integer.MAX_VALUE;
        int i=0;
        int n = arr.length;
        int j = n-1;

        Arrays.sort(arr);

        ArrayList<Integer> solution = new ArrayList<>();

        while(i < j){
            int sum = arr[i] + arr[j];
            int key = Math.abs(sum-target);
            if(key < d){
                d = key;
                first = arr[i];
                second = arr[j];
            }
            if(sum < target)
                i++;
            else
                j--;
        }

        if(first >= 0 && second >= 0){
            solution.add(first);
            solution.add(second);
        }

        return solution;
    }
}