class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length==1&&nums[0]==target)return 0;
        
        int pivot=find_pivot(nums,0,nums.length-1);
        
        if(pivot==-1)return binary_search(nums,target,0,nums.length-1);
        
          if(nums[pivot]==target)return pivot;
        
          else if(nums[0]>target) return binary_search(nums,target,pivot+1,nums.length-1);

       return binary_search(nums,target,0,pivot-1); 
       
    }
    
    public int find_pivot(int nums[],int start,int end){
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(mid<end&&nums[mid]>nums[mid+1])return mid; //mid must be less than end since we are accessing the mid+1 element and if mid is at the end than mid+1 is not possible.
            
            else if(mid>start&&nums[mid]<nums[mid-1])return mid-1;
            
            else if(nums[mid]<=nums[start]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    
    public int binary_search(int []nums,int target,int start,int end){
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(nums[mid]<target) start=mid+1;
            
            else if(nums[mid]>target)end=mid-1;
            
            else return mid;
        }
        return -1;
    }
}
