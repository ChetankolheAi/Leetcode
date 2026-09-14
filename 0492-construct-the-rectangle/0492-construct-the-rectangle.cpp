class Solution {
public:
    vector<int> constructRectangle(int area) {
        int Sqt = sqrt(area);
        vector<int>ans(2);
   
        for(int i=Sqt;i>=1;i--){
            if(area%i==0){
                ans[1] = i;
                break;
            }
        }
        ans[0] =  area/ans[1];
        return ans;
    }
};