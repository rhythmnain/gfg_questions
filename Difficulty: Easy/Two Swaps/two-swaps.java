//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    public boolean checkSorted(List<Integer> arr) {
        // code here
         int count=0, n=arr.size();
        for(int i=0;i<n;i++){
            if(arr.get(i)!=i+1) count++;
        }
        //0 is valid
        //1 is impossible
        //2 is false
        //3 is valid
        //4 is sceptical
        return count==0 || count==3 || (count==4 && verify(arr));
    }
    boolean verify(List<Integer> arr){
        int a=-1, b=-1, c=-1, d=-1, n=arr.size();
        for(int i=0;i<n;i++){
            if(arr.get(i)!=i+1){
                if(a==-1)   a=i;
                else if(b==-1)  b=i;
                else if(c==-1)  c=i;
                else    d=i;
            }
        }
        return verifySwap(arr,a,b) || verifySwap(arr,a,c) || verifySwap(arr,a,d);
    }
    boolean verifySwap(List<Integer> list,int i,int j){
        return list.get(i)==j+1 && list.get(j)==i+1;
    }
}