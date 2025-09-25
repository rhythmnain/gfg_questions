class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
         ArrayList<String>al=new ArrayList<>();
        for(int i=1;i<=n;i++){
            String w=binary(i);
            al.add(w);
        }
        return al;
    }
    public String binary(int k){
        StringBuilder wq=new StringBuilder();
        while(k!=1){
            int m=k%2;
            wq.append(m);
            k=k/2;
        }
        wq.append(1);
        return wq.reverse().toString();
    }
}
