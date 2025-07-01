class Solution {
    public int substrCount(String s, int k) {
        // code here
         int i=0, j=0;
        int n = s.length();
        int cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j<n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
           if (j - i + 1 > k) {
                char c = s.charAt(i);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                i++;
            }
            
            if (j - i + 1 == k && map.size() == k - 1) {
                cnt++;
            }
            
            j++;
        }
        return cnt;
    }
}