class Solution {
public:
    int FindMax(vector<int>&nums , int k){
        int maxi = INT_MIN;
            for(int i : nums){
                maxi = max(i , maxi);
            }
        return maxi;
    }
    int largestInteger(vector<int>& nums, int k) {
        unordered_map<int,int>Freq;
        for(int i : nums){
            Freq[i]++;
        }

        if(k==nums.size()){
            return FindMax(nums,k);
        }
        else if(k==1){
           
            int maxi = INT_MIN;
            for(int i : nums){
                if(Freq[i]==1){
                    cout<<i<<endl;
                    maxi = max(i , maxi);
                }
            }
            return maxi==INT_MIN?-1:maxi;

        }
        
      
        int start = nums[0];
        int end = nums[nums.size()-1];

        if(Freq[start]==1){
            if(Freq[end]==1){
                return max(start , end);
            }
            else{
                return start;
            }
        }
        else if(Freq[end]==1){
            return end;
        }
        // if(Freq[start]==nums.size() && nums.size()==k){
        //     return start;
        // }
        return -1;

    }
};