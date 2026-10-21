class Solution {
    public int characterReplacement(String s, int k) {
        int maxWindow = 0;
        int left = 0;
        int maxFreq = 0;
        int[] freqArr = new int[26];

        for(int right = 0 ;right<=s.length()-1; right ++){
            freqArr[s.charAt(right)-'A']++;
            int windowLen = right - left+1;
            maxFreq= Math.max(maxFreq, freqArr[s.charAt(right)-'A']);

            if(windowLen - maxFreq > k){
                freqArr[s.charAt(left)-'A']--;
                left++;
            }
            windowLen = right - left+1;
            maxWindow = Math.max(windowLen,maxWindow);
        }
        return maxWindow;
    }
}
