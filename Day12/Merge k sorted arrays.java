import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<Integer>qu=new PriorityQueue<>();
        
        for(ArrayList<Integer>list:kArrays){
            for(int i:list){
                qu.offer(i);
            }
        }
        ArrayList<Integer>ar=new ArrayList<>();
        while(qu.size()>0){
            ar.add(qu.peek());
            qu.remove();
        }
        return ar;
	}
}
