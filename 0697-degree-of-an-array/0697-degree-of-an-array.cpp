class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        unordered_map<int,int>Freq;
        for(int i : nums){
            Freq[i]++;
        }
        int maxFreq = 0;
        int maxNum = 0;
        vector<int>Repeat;
        for(auto i  : Freq){
            if(i.second > maxFreq){
                maxFreq = i.second;
             
            }
           

        }
        for(auto i  : Freq){
            if(i.second == maxFreq){
                Repeat.push_back(i.first);
            }
           

        }
        for(int i=0;i<Repeat.size();i++){
            cout<<Repeat[i]<<endl;
        }
        int minSize = INT_MAX;
        for(int j=0;j<Repeat.size();j++){
            
            int numFirstOccurance = -1;
            int numLastOccurance = -1;
            for(int i=0;i<nums.size();i++){

                if(numFirstOccurance == -1 && nums[i] == Repeat[j]){
                    numFirstOccurance = i;
                }
                if(nums[i]==Repeat[j])
                    numLastOccurance = i;
                
            } 
            minSize = min(minSize , (numLastOccurance-numFirstOccurance)+1);
        }
         
        // cout<<numLastOccurance<<endl; 
        // cout<<numFirstOccurance<<endl; 
        return minSize;
    }
};