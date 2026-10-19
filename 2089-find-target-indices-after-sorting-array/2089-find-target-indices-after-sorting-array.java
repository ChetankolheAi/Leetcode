class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        // List<Integer>ans = new ArrayList<>();
        // for(int i = 0; i<nums.length;i++){
        //     if(nums[i]==target){
        //         ans.add(i);
        //     }
        // }
        // return ans;

        int Count = 0;
        int CountNumberLessthantarget = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)Count++;
            if(nums[i]<target){
                CountNumberLessthantarget++;
            }
        }
        List<Integer>ans = new ArrayList<>();
        for(int i=CountNumberLessthantarget;i<(Count+CountNumberLessthantarget);i++){
            ans.add(i);
        }
        return ans;
    }
}