class Solution {
    
    
    public int findMedian(int[] arr) 
    {
        int n = arr.length;
        
        if (n % 2 != 0) return arr[n / 2];
  
        return (arr[(n - 1) / 2] + arr[n / 2]) / 2;

    }
    public int minMoves2(int[] nums) {
    
        Arrays.sort(nums);
    
        int median = findMedian(nums);
    
        int count = 0;
       
        for(int i=0;i<nums.length;i++) count += Math.abs(nums[i]-median);
        
        return count;
       
    }
}

