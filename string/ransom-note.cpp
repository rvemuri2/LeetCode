class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        vector<int> letters(26);
        for (auto c : magazine) {
            letters[c - 'a']++;
        }
        for (auto c : ransomNote) {
            int idx = c - 'a';
            if (letters[idx] == 0) {
                return false;
            }
            letters[idx]--;
        }

        return true;
    }
};