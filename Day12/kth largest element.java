class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>ans=new PriorityQueue<>(Collections.reverseOrder());
        
        int element=0;
        
        for(int i:nums){
            ans.add(i);
        }
        while(ans.size()>0&&k-->0){
            element=ans.peek();
            ans.remove();
        }
        return element;
    }
}
