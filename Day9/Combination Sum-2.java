class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        HashSet<ArrayList<Integer>>set=new HashSet();
        ArrayList<Integer>list=new ArrayList<>();
        
        generate(0,candidates,target,list,set);
        return ans;
    }
    
    public void generate(int index,int[]nums,int target,ArrayList<Integer>list,   HashSet<ArrayList<Integer>>set){
        if(target<0)return;
        
        if(index==nums.length){
            if(target==0){
               if(!set.contains(new ArrayList<>(list))){
                   set.add(new ArrayList<>(list));
                   ans.add(new ArrayList<>(list));
               }
            }
            return;
        }
        if(nums[index]<=target){
            list.add(nums[index]);
            generate(index+1,nums,target-nums[index],list,set);
            list.remove(list.size()-1);
            while(index+1<nums.length && nums[index]==nums[index+1]) index++;
        }
        generate(index+1,nums,target,list,set);
    }
}
