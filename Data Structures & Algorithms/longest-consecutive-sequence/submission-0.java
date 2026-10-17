class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int longestSubSeq = 0;

        for(int n: nums){
            st.add(n);
        }

        for(int n: st){
            int currNum = 0;
            int currSubSeq = 0;
            if(!st.contains(n-1)){
                currNum = n;
                currNum++;
                currSubSeq++;
                while(st.contains(currNum)){
                    currNum++;
                    currSubSeq++;
                }
                longestSubSeq = Math.max(longestSubSeq,currSubSeq);
            }
        }
        return longestSubSeq;
    }
}
