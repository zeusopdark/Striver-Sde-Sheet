/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>q=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        
        for(ListNode list:lists){
            if(list!=null)
            q.add(list);
        }
        while(q.size()>0){
            ListNode current=q.remove();
            prev.next=current;
            prev=prev.next;
            if(current.next!=null){
                q.offer(current.next);
            }
        }
        
        return dummy.next;
    }
}
