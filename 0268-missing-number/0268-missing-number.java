class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = IntStream.rangeClosed(1, nums.length).reduce(0, (a, b) -> a ^ b);
        int xor2 = Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        return xor1 ^ xor2;
    }
}