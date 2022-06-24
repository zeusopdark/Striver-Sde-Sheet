class Solution {
      List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer>list=new ArrayList<>();
        generate(0,list,candidates,target);
        return ans;
    }
    
    public void generate(int index,ArrayList<Integer>list,int[]nums,int target){
        if(target<0)return;
        
        
        if(index==nums.length){
            
        if(target==0){
            ans.add(new ArrayList<>(list));
        }
            return;
    }
        if(nums[index]<=target){
        list.add(nums[index]);
        generate(index,list,nums,target-nums[index]);
        list.remove(list.size()-1);
        }
        generate(index+1,list,nums,target);
        
    }
}
