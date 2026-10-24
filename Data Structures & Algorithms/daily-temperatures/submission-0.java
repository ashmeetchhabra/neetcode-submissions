class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for(int i = n-1; i>=0; i--){
            //step1
            if(st.isEmpty()){
                res[i]=0;
                st.push(i);
            }

            // step 2
            if(temperatures[st.peek()]>temperatures[i]){
                res[i]=st.peek()-i;
                st.push(i);
            }

            //step3
            if(temperatures[st.peek()]<=temperatures[i]){
                while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    st.push(i);
                    res[i]=0;
                }else{
                    res[i]=st.peek()-i;
                    st.push(i);
                }
            }
        }
        return res;
    }
}
