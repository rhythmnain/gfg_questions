class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int n = mat.length;
        int matSum=0; //Total Matrix Sum
        int maxRSum=0, maxCSum=0; // Max Row Sum , Max Column Sum
        
        for(int i=0; i<n; i++) {
            int iRSum=0, iCSum=0; // Individual Row Sum , Individual Column Sum
            for(int j=0; j<n; j++) {
                //Individual Row Sum
                iRSum+=mat[i][j];
                
                //Individual Column Sum
                iCSum+=mat[j][i];
                
                //Matrix Sum
                matSum+= mat[i][j];
            }
            maxRSum = Math.max(iRSum, maxRSum);
            maxCSum = Math.max(iCSum, maxCSum);
        }
        int max = Math.max(maxRSum, maxCSum); // Max out of Column and Row
        
        return (max*n)-matSum;
    }
}