class Solution {
    public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //     for(int num: nums){
    //         minHeap.offer(num);
    //         if(minHeap.size()>k)
    //             minHeap.poll();
    //     }

    //     return minHeap.peek();
        
//------------------------------------------------------------------------------ 
        //Using Pivot:
        return quickSelect(nums,k,0,nums.length-1);
    }

    private int quickSelect(int[] nums, int k,int left, int right){
        int pivot = left;
        for(int i = left; i<right;i++){
            if(nums[i]<=nums[right]){
                swap(nums,pivot,i);
                pivot++;
            }
        }
        swap(nums,pivot,right);
        //to check how many elements to the right of pivot
        int count = right-pivot+1;
        if(count==k)
            return nums[pivot];
        else if(count>k)
            return quickSelect(nums,k,pivot+1,right);
            //need to have k-count as right portionn is discarded so only to search left elements
        return quickSelect(nums,k-count,left,pivot-1);
    }

    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x]=nums[y];
        nums[y]=tmp;
    }
}
