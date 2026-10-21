class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st =  new HashSet<>();
        int left = 0;
        int longestSubstring = 0;
        for(int right = 0;right<=s.length()-1; right++){

            while(st.contains(s.charAt(right))){
                st.remove(s.charAt(left));
                left++;
            }

            st.add(s.charAt(right));
            longestSubstring = Math.max(longestSubstring, right - left +1);


        }
        return longestSubstring;
    }
}
