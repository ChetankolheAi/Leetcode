class Solution {
    int finNextIndex(int[] nums , int start){
        for(int i=start ;i<nums.length;i++){
            if(nums[i]==0)return i;
        }
        return -1;
    }
    public void moveZeroes(int[] nums) {
        int swappingIndex = -1;
        for(int i=0;i<nums.length;i++){

            if(nums[i]==0 && swappingIndex==-1){
                swappingIndex = i;
            }
            else if(swappingIndex != -1){
                int temp = nums[i];
                nums[i] = nums[swappingIndex];
                nums[swappingIndex] = temp;
                swappingIndex = finNextIndex(nums , swappingIndex);

            }
            else if(nums[i]==0){
                swappingIndex  = i;
            }
        }
    
    }
}