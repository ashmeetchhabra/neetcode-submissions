class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            //make sure first element is not duplicate
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int first = nums[i];
                int target = 0-first;
                int low = i+1;
                int high = nums.length -1;

                while(low<high){
                    if(nums[low]+nums[high]==target){
                        outputList.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        //make sure low is not duplicate
                        while(low<high && nums[low]==nums[low+1])
                            low++;
                        //make sure high is not duplicate
                        while(low<high && nums[high]==nums[high-1])
                            high--;
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]>target)
                        high--;
                    else if(nums[low]+nums[high]<target)
                        low++;
                }
            }
        }
        return outputList;
    }
}
