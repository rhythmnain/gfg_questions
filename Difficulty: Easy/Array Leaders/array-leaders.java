class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> List = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            boolean isHead = true;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j]>arr[i]){
                    isHead=false;
                    break;
                }
            }
            if(isHead==true){
                List.add(arr[i]);
            }
        }
        return List;
    }
}
