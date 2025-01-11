//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int maxSize = 0; // To store the size of the longest unique substring
        int pointer = 0; // Start index of the current window

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is already in the map and is within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= pointer) {
                // Move the pointer to the right of the last occurrence
                pointer = map.get(currentChar) + 1;
            }

            // Update the character's last occurrence in the map
            map.put(currentChar, i);

            // Calculate the maximum size of the unique substring
            maxSize = Math.max(maxSize, i - pointer + 1);
        }

        return maxSize;
    }
}