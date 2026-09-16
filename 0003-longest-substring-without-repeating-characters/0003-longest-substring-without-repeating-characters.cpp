class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        int maxSize = 0;
        unordered_map<char , int>Freq;
        int i=0;
        for(i=0;i<s.size();i++){
            if(Freq[s[i]] > start && i>0){
                cout<<start<<","<<s[i]<<","<<i<<endl;
                int winSize = i-start;
                maxSize = max(winSize , maxSize);
                int idx = Freq[s[i]];
                start = idx;

            }
            
            Freq[s[i]] = i+1;
            
        }
        int winSize = (i)-start;
        maxSize = max(winSize , maxSize);
        return maxSize;
    }
};