class Solution {
public:
    int missingInteger(vector<int>& nums) {
        unordered_map<int, int> Freq;
        for (int i : nums) {
            Freq[i] = 1;
        }

        int LongestSeqPrefixSum = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i - 1] + 1) {
                LongestSeqPrefixSum += nums[i];
            } else {
                break;
            }
        }

        int StartNum = LongestSeqPrefixSum;
        while (Freq[StartNum] >= 1) {
            StartNum++;
        }

        return StartNum;
    }
};