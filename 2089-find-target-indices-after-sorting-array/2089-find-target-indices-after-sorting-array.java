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
        int CountLessTtarget = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)Count++;
            else if(nums[i]<target){
                CountLessTtarget++;
            }
        }
        List<Integer>ans = new ArrayList<>();
        for(int i=CountLessTtarget;i<(Count+CountLessTtarget);i++){
            ans.add(i);
        }
        return ans;
    }
}