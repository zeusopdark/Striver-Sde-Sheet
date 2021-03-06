import java.util.*;
public class Solution {
    
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer>list=new ArrayList<>();
        int sum=0;
        getsum(num,sum,0,list);
        Collections.sort(list);
        return list;
    }
  public static void getsum(int[]num,int sum,int index,ArrayList<Integer>list){
      if(index==num.length){
          list.add(sum);
          return;
      }
      int n=num[index];
      getsum(num,sum+n,index+1,list);
      getsum(num,sum,index+1,list);
  }
}
