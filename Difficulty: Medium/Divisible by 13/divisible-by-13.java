class Solution {
    public boolean divby13(String s) {
        // code here
        int bal =0;
        
        for(int i= 0; i<s.length(); i++){
            bal=(bal*10 +(s.charAt(i)-'0'))%13;
        }
        return bal ==0;
    }
}