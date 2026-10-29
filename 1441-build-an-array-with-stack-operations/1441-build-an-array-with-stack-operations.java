class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String>ans = new ArrayList<>();

        int k = 1;
        for(int i=0;i<target.length;i++){
            if(target[i] == k){
                ans.add("Push");
                k++;
                continue;
            }
            for(int j=0 ; j < (target[i]-k) ; j++){
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
            k = target[i]+1;
        }
        return ans;
    }
}