//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
           int i=a.length-1;
        int j= 0;
        while(i>=0){
          if(a[i]>b[j]){
              swap(i,j,a,b);
              i--;
              j++;
          }
          else{
              break;
          }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    if((k-1)<=a.length-1){
    return   search(0,a.length-1,a,k-1);    
    }
    return search(0,b.length-1,b,(k-1)-(a.length));
    }
   void  swap(int i,int j,int a[],int b[]){
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
    int search(int low,int high,int a[],int key){
       while(low<=high){
           int mid = (low+high)/2;
         if(mid==key) return a[mid];
         else if(key>mid) low = mid +1;
         else high = mid-1;
       }
       return -1;
    }
}