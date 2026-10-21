class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Freq[] = new int[26];
        int windowFreq[] = new int[26];

        if(s1.length()>s2.length())
            return false;
        
        for(int i = 0; i<s1.length(); i++){
            s1Freq[s1.charAt(i)-'a']++;
        }

        //start of the window
        int left = 0;
        for(int right=0; right<=s2.length()-1; right++){
            windowFreq[s2.charAt(right)-'a']++;

            if(right-left+1>s1.length()){
                windowFreq[s2.charAt(left)-'a']--;
                left++;
            }

            if(Arrays.equals(s1Freq,windowFreq))
                return true;
        }
        return false;
    }
}
