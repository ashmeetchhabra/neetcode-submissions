class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Step1: Initialize
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n-k+1];// there will be n-k+1 windows

        //Step 2:populate deque with 1st window and take out max
        for(int i = 0; i<=k-1; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res[0] = nums[deque.peekFirst()];

        //Step 3: process remaining elements
        for(int i = k; i<=n-1; i++){
            if(deque.peekFirst()<=i-k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            res[i-k+1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
