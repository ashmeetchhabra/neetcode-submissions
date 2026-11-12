class Solution {
    public int lastStoneWeight(int[] stones) {
        //Create maxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        //Populate priority queue
        for(int stone: stones){
            pq.offer(stone);
        }

        //we need minimum 2 elements in maxHeap
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(x!=y)
                pq.offer(x-y);
        }
        return (pq.size()==0)? 0: pq.poll();
    }
}
