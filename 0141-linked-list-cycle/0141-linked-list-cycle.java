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
    public boolean hasCycle(ListNode head) {
        // Floyd's Tortoise-Hare algorithm is just for this problem.
        
        ListNode tortoise = head;
        ListNode hare = head;
        boolean result = false; // Key Point
        
        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            
            if(tortoise == hare){result = true; break;}
        }
        
        return result;
    }
}