class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(target==nums[mid])        
                return mid;
            //if left is sorted
            if(nums[left]<=nums[mid]){
                //if target is on left
                if(target<nums[left] || target>nums[mid])
                    left = mid +1;
                else right = mid-1;
            }
            else{
                //right is sorted
                //if target on left
                if(target<nums[mid] || target>nums[right])
                    right = mid-1;
                else left = mid+1;
            }
        }
        return -1;
    }
}
