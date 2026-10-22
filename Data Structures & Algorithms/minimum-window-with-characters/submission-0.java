class Solution {
    public String minWindow(String s, String t) {
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];

        int left = 0;
        int minWin=Integer.MAX_VALUE;
        int minStart = 0;

        for(int i = 0;i<=t.length()-1; i++){
            tFreq[t.charAt(i)]++;
        }        

        for(int right =0; right<=s.length()-1; right++){
            sFreq[s.charAt(right)]++;
            while(isFreqMatch(sFreq,tFreq)){
                if(right-left+1<minWin){
                    minWin= right-left+1;
                    minStart=left;
                }
                sFreq[s.charAt(left)]--;
                left++;
            }
        }
        return minWin==Integer.MAX_VALUE? "" : s.substring(minStart, minStart+minWin);
    }

    private boolean isFreqMatch(int[] sFreq, int[] tFreq){
        for(int i = 0; i<256; i++){
            if(sFreq[i]<tFreq[i])
                return false;
        }
        return true;
    }
}
