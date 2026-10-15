class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String s: strs){
            List intList = new ArrayList<>();
            String frStr = getFreqStr(s);
            if(mp.containsKey(frStr)){
                mp.get(frStr).add(s);
            }else{
                intList.add(s);
                mp.put(frStr,intList);
            }
        }
        return new ArrayList<>(mp.values());
    }

    private String getFreqStr(String s){
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']=arr[c-'a']+1;
        }
        for(int i = 0;i<26;i++){
            sb.append((char)i+'a');
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
