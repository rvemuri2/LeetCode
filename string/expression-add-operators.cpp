class Solution {

public:
    vector<string> addOperators(string num, int target) {
        vector<string> result;
        
        dfs(num, target, {}, {}, {}, {}, result);
        return result;
    }
    
private:
    void dfs(const string& num, int target, int pos, long long eval, long long multed, string path, vector<string>& result) {
        if (pos == num.length()) {
            if (eval == target)
                result.push_back(path);
            return;
        }
        
        for (int i = pos; i < num.length(); i++) {
            
            string cur = num.substr(pos, i - pos + 1);
            
            if (cur.length() > 1 && cur[0] == '0')
                break;
            
            long long curVal = stoll(cur);
            
            if (pos == 0) {
                dfs(num, target, i + 1, curVal, curVal, cur, result);
            } else {

                dfs(num, target, i + 1, eval + curVal, curVal, path + "+" + cur, result);
                
                dfs(num, target, i + 1, eval - curVal, -curVal, path + "-" + cur, result);
                
                dfs(num, target, i + 1, eval - multed + multed * curVal, multed * curVal, path + "*" + cur, result);
            }
        }
    }
};