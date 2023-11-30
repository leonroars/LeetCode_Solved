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
    public ListNode middleNode(ListNode head) {
        // Using Floyd's Hare-Tortoise Algorithm.
        ListNode tortoise = head;
        ListNode hare = head;
        
        // Not (hare != null && hare.next != null). ORDER MATTERS.
        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next; // Safe from NPE.
        }
        
        return tortoise;
    }
}