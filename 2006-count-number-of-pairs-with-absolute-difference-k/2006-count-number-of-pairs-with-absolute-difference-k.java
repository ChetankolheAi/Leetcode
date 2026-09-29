class Solution {
    public int countKDifference(int[] nums, int k) {
        // Map<Integer,Integer>mp = new HashMap<>();
        // int count = 0;
        // for(int i=0;i<nums.length;i++){
        //     int diff = nums[i]-k;
        //     if(mp.containsKey(diff) && diff == k ){
        //         count++;
        //     }
        //     mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        
        // }
        // return count;

        int count  = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])==k && i<j){
                    count++;
                }
            }
        }
        return count;
    }
}