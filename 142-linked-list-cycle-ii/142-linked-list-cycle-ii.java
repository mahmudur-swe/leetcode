/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next==null || head.next.next==null){
            return null;
        }
        
        if(head.next == head){
            return head;
        }
        
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(slow!=fast){
            
            if(slow.next == null || fast.next == null || fast.next.next == null){
                return null;
            }
         
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        
        while(head!=fast){
            
            head = head.next;
            fast = fast.next;
                        
        }
        
        return head;
        
        
    }
}