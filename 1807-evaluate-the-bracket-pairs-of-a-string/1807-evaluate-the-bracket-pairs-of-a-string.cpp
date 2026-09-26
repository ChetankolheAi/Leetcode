class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        unordered_map<string, string>know;
        for(auto i : knowledge){
            know[i[0]] = i[1];
        }

     

        int j = 0;
        bool flag = false;
        string subString = "";
        string ans ="";
        for(int i=0;i<s.size();i++){
            if(s[i]=='('){
                flag = true;
                continue;
            }
            
            else if(s[i]==')'){
            
                auto it = know.find(subString);

                if (it != know.end()) ans+=it->second;   
                else ans+='?';

                flag = false;
                subString = "";
                continue;
            }
        
            if(flag) subString+=s[i];
            else if(!flag) ans+=s[i];
            
        }
        return ans;
    }
};