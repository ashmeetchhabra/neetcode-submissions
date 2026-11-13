class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //Create a maxHeap.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->dist(b)-dist(a));
        int[][] res = new int[k][2];

        //populate the maxHeap
        for(int[] point: points){
            maxHeap.offer(point);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }

        int i =0;
        while(!maxHeap.isEmpty()){
            res[i]= maxHeap.poll();
            i++;
        }
        return res;
    }

    private int dist(int[] point){
        int x = point[0];
        int y = point[1];
        return ((x*x)+(y*y));
    }
}
