class Solution {
    List<List<Integer>>res=new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer>list=new ArrayList<>();
        HashSet<ArrayList<Integer>>set=new HashSet<>();
        generator(set,list,0,nums);
        return res;
    }
    public void generator( HashSet<ArrayList<Integer>>set,ArrayList<Integer>list,int index,int[]nums){
        if(index==nums.length){
            if(!set.contains(new ArrayList<>(list))){
                set.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        list.add(nums[index]);
        generator(set,list,index+1,nums);
        list.remove(list.size()-1);
        generator(set,list,index+1,nums);
    }
}
