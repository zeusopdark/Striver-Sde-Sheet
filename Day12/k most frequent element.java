class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer>list=new ArrayList(map.keySet());
        Collections.sort(list,(a,b)->{
           return map.get(b)-map.get(a);
        });
        int array[]=new int[k];
         int i = 0;
        while(i != k){
            res[i] = al.get(i);
            i++;
        }
        return array;
        
        
    }
}
