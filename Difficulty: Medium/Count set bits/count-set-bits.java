class Solution {
    public static int countSetBits(int n) {
        // code here
        if (n == 0) return 0;


        int p = Integer.highestOneBit(n); // largest power of 2 <= n // in this case => 16
        int x = Integer.numberOfTrailingZeros(p); // gives exponent // in this case => 4

        int bitsTill2x = x * (p >> 1);  // 4 * (16 >> 1) => 4 * (8) = 32
        
        int msbBits = n - p + 1;

        return bitsTill2x + msbBits + countSetBits(n - p);
    }
}