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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Use 3 pointers to solve this problem.
        ListNode p1 = head;
        ListNode p2;
        ListNode p3 = null;
        
        while(true){
            p2 = p1;
            for(int i = 0; i < n - 1; i++){p2 = p2.next;}
            if(p2.next == null){break;}
            
            p3 = p1;
            p1 = p1.next;   
        }
        
        if(p1 == head){
            p3 = head.next;
            head.next = null;
            head = p3;
            return head;
        }else{
            p3.next = p1.next;
            p1.next = null;
            
            return head;
        }
        
    }
}