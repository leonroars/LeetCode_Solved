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
        // Concept : Two Pointers, O(n)
        // Idea
        // 1) Stretch 'fast' pointer to the k-th index from `slow` pointer at first.
        //  - While doing so, check if `fast` reaches end - which is 'null'.
        // 2) If `fast` pointer reaches destination & not eqaul to tail, 
        //    Move `slow` pointer and `fast` pointer at the same time by one index per each iteration.
        // 3) If `fast` pointer reaches tail node, return a node at `slow` pointer location.
        
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode priorSlow = head;
        
        // 1. Stretching `fast` pointer.
        for(int i = 0; i < n; i++){
                fast = fast.next;
        }
        
        // 1.5 Edge-Case
        if(fast == null){
            head = slow.next;
            
            return head;
        }
        
        // 2. Moves both pointer.
        while(fast != null){
            priorSlow = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        // 3. Removing a node at `slow` pointer location.
        priorSlow.next = slow.next;
        slow.next = null;
        
        return head;
        
    }
}