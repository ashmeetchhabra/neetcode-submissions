class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mp = new HashMap<>();
        
        for(String str: strs){
            int[] charCount = new int[26];
            // for(char c: str.toCharArray()){
            //     charCount[c-'a']++;
            // }


            for(int j = 0;j<str.length();j++){
                charCount[str.charAt(j)-'a']++;
            }
            String key = Arrays.toString(charCount);
            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(str);
        }
        return new ArrayList<>(mp.values());
        
    }
}
