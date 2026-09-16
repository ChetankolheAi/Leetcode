class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        int maxSize = 0;
        unordered_map<char , int>lastSeen;
        int i=0;
        for(i=0;i<s.size();i++){
            if(lastSeen[s[i]] > start && i>0){
                int crrWinSize = i-start;
                maxSize = max(crrWinSize , maxSize);
                start = lastSeen[s[i]];
            }
            lastSeen[s[i]] = i+1;  
        }
        int crrWinSize = (i)-start;
        maxSize = max(crrWinSize , maxSize);

        return maxSize;
    }
};