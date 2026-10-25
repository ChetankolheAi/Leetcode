class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum=0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            int temp = nums[i];
            while(temp>0){
                int digit = temp%10;
                temp/=10;
                digitSum +=digit;
            }
        }
        return Math.abs(sum-digitSum);
        
    }
}