class Solution {
public:
    string shortestCompletingWord(string lp, vector<string>& w) {
        unordered_map<char,int>FreqPlate;
        for(int i = 0;i<lp.size();i++){
            if(lp[i]>64 && lp[i]<=90){
                FreqPlate[lp[i]+32]++;
            }
            else if(lp[i]>=97 && lp[i]<=122){
                FreqPlate[lp[i]]++;
            }
        }
        stable_sort(w.begin(), w.end(), [](string a, string b) {
            return a.length() < b.length();
        });        
        for(int i = 0;i<w.size();i++){
            unordered_map<char,int>Temp = FreqPlate;
            for(int j=0;j<w[i].size();j++){
                if(w[i][j]>64 && w[i][j]<=90){
                    Temp[w[i][j]+32]--;
                }
                else if(w[i][j]>=97 && w[i][j]<=122){
                    Temp[w[i][j]]--;
                }
            }
            bool isTrue = true;
            for(auto i : Temp){
                if(i.second>0){
                    isTrue = false;
                }
            }
            if(isTrue)return w[i];
           
        }
        return "";
        
    }
};