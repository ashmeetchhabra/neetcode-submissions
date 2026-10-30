class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length>=nums2.length? nums2:nums1;
        int[] larger = nums1.length>=nums2.length? nums1:nums2;
        int totalLen = nums1.length+nums2.length;
        int res = -1;
        int left=0;
        int right= smaller.length;

        while(left<=right){
            int midSmaller = (left+right)/2;
            int t = totalLen%2==0 ? totalLen/2 : (totalLen+1)/2;
            int midLarger = t-midSmaller;

            int l1 = midSmaller==0 ? Integer.MIN_VALUE : smaller[midSmaller-1];
            int r1 = midSmaller==smaller.length ? Integer.MAX_VALUE : smaller[midSmaller];

            int l2 = midLarger==0 ? Integer.MIN_VALUE : larger[midLarger-1];
            int r2 = midLarger==larger.length ? Integer.MAX_VALUE : larger[midLarger]; 

            if(l1<=r2 && l2<=r1){
                return totalLen%2==0 ? (Math.max(l1,l2)+Math.min(r1,r2))/2.0 : Math.max(l1,l2);
            }
            if(l1>r2)
                right = midSmaller-1;
            else
                left = midSmaller+1;
        }
        return res;
    }
}
