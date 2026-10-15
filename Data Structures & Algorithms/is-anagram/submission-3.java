class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        else{
            if(getFreqStr(s).equals(getFreqStr(t)))
                return true;
        }
        return false;
    }

    private String getFreqStr(String s){
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']=arr[c-'a']+1;
        }
        for(int i = 0;i<26;i++){
            sb.append(i+'a');
            sb.append(arr[i]);
        }
        return sb.toString();

    }
}
