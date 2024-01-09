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
    public ListNode partition(ListNode head, int x) {
                
        /* Overall Approach
         * 0. Initialize two nodes. They will be the dummy head node of smaller nodes list and bigger nodes list.
         * 1. Initialize two nodes. They will be the tail node pointer for splited lists.
         * 2. Link two splited lists into one, update head and return it.
         */
        
        // Edge case handling. If given linked list is currently empty, return it without changing anything.
        if(head != null){
            ListNode dummy1 = new ListNode(0);
            ListNode dummy2 = new ListNode(0);
            
            ListNode dummy1tail = dummy1;
            ListNode dummy2tail = dummy2;
            
            ListNode loc = head;
            
            while(loc != null){
                if(loc.val < x){
                    dummy1tail.next = loc;
                    dummy1tail = dummy1tail.next;
                } else {
                    dummy2tail.next = loc;
                    dummy2tail = dummy2tail.next;
                }
                loc = loc.next;
            }
            
            dummy2tail.next = null;
            dummy1tail.next = dummy2.next;
            head = dummy1.next;
        }
        
        return head;
        
    }
}