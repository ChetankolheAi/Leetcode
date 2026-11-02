class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum  = (n*(n+1))/2;
        int arrSum = IntStream.of(nums).sum();
        return sum-arrSum;
    }
}