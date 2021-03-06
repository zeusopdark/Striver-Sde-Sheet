//when array is given..

class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
       permutations(nums,new ArrayList<Integer>());
        return ans;
    }
    
    public void permutations(int[]nums,ArrayList<Integer>list){
        if(nums.length==list.size()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){continue;}
            list.add(nums[i]);
            permutations(nums,list);
            list.remove(list.size()-1);
        }
    }
}

//when string is given....


import java.util.*;
public class Solution {
   static List<String>list=new ArrayList<>();
    public static List<String> findPermutations(String s) {
        permute(s,new ArrayList<Character>());
        return list;
    }
    
    public static void permute(String s,ArrayList<Character>ans){
        if(s.length()==0){
            String asf=" ";
            for(char sp:ans){
                asf+=sp;
            }
            list.add(asf);
            return;
        }
        for(int i=0;i<s.length();i++){
            ans.add(s.charAt(i));
            String ss=s.substring(0,i)+s.substring(i+1);
            permute(ss,ans);
            ans.remove(ans.size()-1);
        }
    }
}
