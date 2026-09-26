class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {

        unordered_map<string, string>keyValue;
        for(auto key : knowledge){
            keyValue[key[0]] = key[1];
        }

 
        bool flag = false;
        string subString = "";
        string ans ="";

        for(int i=0;i<s.size();i++){

            if(s[i]=='('){
                flag = true;
                continue;
            }
            
            else if(s[i]==')'){
            
                auto it = keyValue.find(subString);

                if (it != keyValue.end()) ans+=it->second;   
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