class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length<2)return nums[0];
      if(nums.length>2&&nums[0]!=nums[1])return nums[0];
        if(nums.length>2&&nums[nums.length-1]!=nums[nums.length-2])return nums[nums.length-1];
        
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]) return nums[mid];
            
            if((nums[mid]==nums[mid+1]&&mid%2==1)||((nums[mid]==nums[mid-1]&&(mid-1)%2==1))){
                high=mid-1;
            }
            else{
               low=mid+1;
            }
        }
        return nums[mid];
    }
}
