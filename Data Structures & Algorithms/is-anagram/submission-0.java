class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int [] charCount = new int[26];
        int sum=0;
        for(char c: s.toCharArray()){
            charCount[c-'a'] ++;
        }
        for(char c: t.toCharArray()){
            if(charCount[c-'a']>=1)
                charCount[c-'a'] --;
        }
        for(int i = 0;i<26;i++){
            sum+=charCount[i];
        }
        if(sum==0)
            return true;
        return false;

    }
}
