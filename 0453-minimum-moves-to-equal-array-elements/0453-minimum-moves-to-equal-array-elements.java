class Solution {
    public int minMoves(int[] nums) {     
        int count = 0;
        int minElement = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) minElement = Math.min(minElement,nums[i]);
        for(int i=0;i<nums.length;i++) if(nums[i]!=minElement) count+=nums[i]-minElement;
        return count;
    }
}