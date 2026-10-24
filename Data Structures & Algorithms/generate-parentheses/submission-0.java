class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<String> st = new Stack<>();
        List<String> res = new ArrayList<>();
        backtrack(0,0,n,st,res);
        return res;
    }

    private void backtrack(int openN, int closeN, int n, Stack<String> st, List<String> res){
        if(openN == n && closeN == n){
            res.add(String.join("",st));
            return;
        }
        if(openN<n){
            st.push("(");
            backtrack(openN+1, closeN, n, st, res);
            st.pop();
        }
        if(openN>closeN){
            st.push(")");
            backtrack(openN, closeN+1, n, st, res);
            st.pop();
        }
    }
}
