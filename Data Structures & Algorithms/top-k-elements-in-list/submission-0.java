class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];

        //creating a freqMap
        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }

        //populate the bucket
        for(int key: freqMap.keySet()){
            int frequency = freqMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int counter = 0;
        int[] res = new int[k];
        for(int pos = bucket.length-1;pos>=0 && counter<k;pos--){
            if(bucket[pos]!=null){
                for(Integer i : bucket[pos])
                    res[counter++]= i;

            }

        }
        return res;
    }
}
