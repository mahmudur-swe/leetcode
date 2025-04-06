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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode startNode = null;

        ListNode lastNode = null;

        int offset = 0;

        while(l1 != null || l2 != null ){

            int val1 = 0;
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }

            int val2 = 0;

            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            

            int sum = val1 + val2 + offset;

            
            int val = sum % 10;

            offset = sum/10;


            ListNode newNode = new ListNode(val);

           // System.out.println("Sum " + val);

              
            if(lastNode == null){
                startNode = newNode;
            }else{
                lastNode.next = newNode;
            }

           

            lastNode = newNode;

            if(l1 == null && l2==null & offset>=1){
                newNode = new ListNode(offset);
                lastNode.next = newNode;
            }

             //System.out.println("Sum " + val + " " + newNode.val);

        }

        return startNode;
        

    }
}