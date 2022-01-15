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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0){
            return head;
        }
        
        if(head == null){
            return head;
        }
        
        int length = 0;
        
        ListNode root = head;
        
        ListNode fNode = head;
        ListNode bPoint = head;;
        
        for(int i=0;i<k;i++){
            
            if(root==null){  
                k = k%length;
                length = -1;
                break;
            }
            root = root.next;
            fNode = root;
            length++;
            
        }
        
        
        
        if(length == -1){
            root = head;
            for(int i=0;i<k;i++){
                root = root.next;
                fNode = root;
            }
        }
        
        if(fNode==null){
            return head;
        }
        
        root = head;
        
        while(fNode.next!=null){
            fNode = fNode.next;
            root = root.next;
        }
        
        bPoint = root.next;
        
        root.next = null;
        
        fNode.next = head;
        
        return bPoint;
        
    }
}