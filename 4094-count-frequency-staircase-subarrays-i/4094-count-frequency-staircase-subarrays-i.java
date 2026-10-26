import java.util.*;

class Solution {
    public int countStaircase(int[] nums) {
        int count = 0;
        
        for (int j = 0; j < nums.length; j++) {

            Map<Integer, Integer> freqMap = new HashMap<>();
            List<Integer> distinctList = new ArrayList<>();
            
            for (int i = j; i < nums.length; i++) {
                int val = nums[i];
                
                if (!freqMap.containsKey(val)) {
                    distinctList.add(val);
                }
                
                freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
                
                boolean isValid = true;

                for (int k = 0; k < distinctList.size(); k++) {
                    
                    int element = distinctList.get(k);
                    int requiredFrequency = k + 1; 
                    
                    if (freqMap.get(element) != requiredFrequency) {
                        isValid = false;
                        break;
                    }
                }
                
                if (isValid) {
                    count++;
                }
            }
        }
        
        return count;
    }
}