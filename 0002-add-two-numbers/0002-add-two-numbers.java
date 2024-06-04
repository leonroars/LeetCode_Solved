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
        // ===  Approach === //
        // The point of this question is whether we can make a calculator adding two numbers
        // that are not zero themselves, with carrying-in and out functioning.
        // In such sense, we can think of following specifications for our solution.
        //  1. Given numbers' digits are reverse-ordered. A digit at 10^0 place comes first.
        //  2. Iterate from the first digit to the last digit of each numbers and add them up sequently.
        //     This iteration ends when it reaches end of the both linked lists.
        //     If the sum of digits exceeds 10, set carry flag 'true'.
        //     If the carry flag is set to be 'true' at the end of the iteration,
        //     create new ListNode having '1' as its value
        //     and make it end of the result linked list.
        // ==== Time Complexity === 
        // As it requires full-linear search through both given linked lists l1 and l2,
        // time complexity of the solution is O(n) at best.
        
        boolean carry = false; // Boolean flag for carry.
        ListNode result = null; // The head node of result linked list.
        
        ListNode l1Current = l1; // Iterator for l1.
        ListNode l2Current = l2; // Iterator for l2.
        ListNode resultCurrent = result; // Iterator for 'result' linked list.
        
        while(l1Current != null || l2Current != null){
            int sum;
            // Case I : Both list iterator is not at the end.
            if(l1Current != null && l2Current != null){
                // Carry condition
                if(carry){sum = l1Current.val + l2Current.val + 1; carry = false;}
                else{sum = l1Current.val + l2Current.val;}
                
                // digit addition condition
                if(sum > 9){carry = true; sum = sum - 10;}
                
                // Constructing result linked list.
                if(result == null){
                    resultCurrent = new ListNode(sum);
                    result = resultCurrent;
                } else {
                    resultCurrent.next = new ListNode(sum);
                    resultCurrent = resultCurrent.next; // moving result iterator to next node.
                }
                // Moving l1,l2 iterator.
                l1Current = l1Current.next;
                l2Current = l2Current.next;
            }
            // Case II : Iterator for one of two given list reaches end.
            else{
                if(l1Current == null){
                    if(carry){sum = l2Current.val + 1; carry = false;}
                    else{sum = l2Current.val;}
                    l2Current = l2Current.next;
                } else{
                    if(carry){sum = l1Current.val + 1; carry = false;}
                    else{sum = l1Current.val;}
                    l1Current = l1Current.next;
                }
                if(sum > 9){
                    sum = sum - 10;
                    carry = true;
                }
                resultCurrent.next = new ListNode(sum);
                resultCurrent = resultCurrent.next;
            }
        }
        
        // Processing over both lists ended.
        if(carry){
            resultCurrent.next = new ListNode(1);
            resultCurrent = resultCurrent.next;
        }
        
        return result;
    }
}