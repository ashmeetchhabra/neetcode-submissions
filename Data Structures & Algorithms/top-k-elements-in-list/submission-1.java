class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->mp.get(a)-mp.get(b));
        int[] res = new int[k];
        for(int n: nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }

        for(Integer n : mp.keySet()){
            pq.add(n);
            if(pq.size()>k)
                pq.poll();
        }

        if(!pq.isEmpty()){
            for(int i = 0;i<k;i++){
                res[i] = pq.poll();
            }
        }
        return res; 
    }
}
