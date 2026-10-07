class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        // Map<Integer,Integer> map = new HashMap<>();
        // Map<List<Integer>,Integer> ListCheck = new HashMap<>();
        for(int i=0;i<=nums.length-4;i++)
        {
            for(int j=i+1;j<=nums.length-3;j++)
            {   
                long sum = nums[i]+nums[j];
                long diff = target - sum;
                int left  =  j+1;
                int right =  nums.length-1;
                while(left<right){
                    if(nums[left]+nums[right] > diff){
                        right--;
                    }
                    else if(nums[left]+nums[right] <  diff){
                        left++;
                    }
                    else{
                   
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--; 
                        
                    }
                    
                }
            }
                    
        }
        List<List<Integer>> listAns = new ArrayList<>(ans);
        return listAns;
    }
}