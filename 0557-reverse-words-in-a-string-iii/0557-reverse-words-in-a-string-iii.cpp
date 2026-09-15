class Solution {
public:
    string ReverseString(string s){
        string ans = "";
        for(int i=s.size()-1;i>=0;i--){
            ans+=s[i];
        }
        return ans;
    }
    string reverseWords(string s) {
        string ans ="";
        string temp ="";
        for(int i=0;i<s.size();i++){
            if(s[i]==' '){
                string Rev = ReverseString(temp);
                ans += Rev;
                ans+=' ';
                temp = "";

            }
            else{
                temp+=s[i];
            }
        }
        if(temp!=""){
            string Rev = ReverseString(temp);
            ans += Rev;
        }
        return ans;
    }
};