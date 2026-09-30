class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        int CrrDepth = 0;
        vector<int>ans(seq.size());
        for(int i=0;i<seq.size();i++){
            int temp = 0;
            if(seq[i]=='('){
                CrrDepth++;
            }
            else if(seq[i]==')'){
                temp = CrrDepth;
                CrrDepth--;
            }
            temp = max(temp,CrrDepth);

            if(temp%2==0){
                ans[i]=1;
            }
            else{
                ans[i]=0;
            }


        }
        
        return ans;
    }
};