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
        
        int total = 1;
        
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(slow!=fast){
            
            if(slow.next == null || fast.next == null || fast.next.next == null){
                return null;
            }
            
            total++;
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        //System.out.println("slow "+ slow.val);
        
      
        
        if(slow.next == slow){
            return slow;
        }
        
        if(slow.next.next == slow){
            return slow;
        }
        
        int count = 0;
        
        fast = slow;
        
        Set<ListNode> nodes = new HashSet();
        
        while(true){
            
            if(count>0 && slow == fast){
                break;
            }
            nodes.add(fast);
            count++;
            fast = fast.next;
                        
        }
        
        while(true){
            
            if(nodes.contains(head)){
                return head;
            }
            
            head = head.next;
            
        }
        
        //System.out.println(total+" "+count);
        
        //return slow;
        
//         ListNode root = head;
        
//         for(int i=0;i<k;i++){
            
//             root = root.next;
            
//         }
        
    }
}