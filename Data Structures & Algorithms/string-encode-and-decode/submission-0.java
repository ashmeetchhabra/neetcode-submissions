class Solution {
    char DELIMITER='#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append(DELIMITER);
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        char[] arrCh = str.toCharArray();
        for(int i = 0;i<arrCh.length;i++){
            StringBuilder sb = new StringBuilder();
            while(arrCh[i]!=DELIMITER){
                sb.append(arrCh[i]);
                i++;
            }
            int lenOfStr = Integer.valueOf(sb.toString());
            sb = new StringBuilder();
            i++;
            int endIndex = lenOfStr + i;
            for(int j=i;j<endIndex;j++){
                sb.append(arrCh[j]);
            }
            i=endIndex-1;
            res.add(sb.toString());
        }
        return res;
    }
}
