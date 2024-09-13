import java.util.Stack;
import java.util.HashMap;

/*
 [Main Idea] : Stack(For flipping number sequence horizontally) + BitSet(For rotating each number vertically)
 
 [Processes]
 0. Instantiate boolean variable 'answer' to store the answer.
    Then initialize it as false.
    Instantiate String variable 'flipped' to store flipped version of given number n.
    And set it as "".
    
 1. Instantiate Stack and HashMap.
    And add <0, 0>, <1, 1>, <6, 9>, <8, 8>, <9, 6>.
    
 2. Instantiate String type variable 'nStr' and initialize it as Integer.toString(n).
 
 3. For each char 'c' in String 'n',
    Store 'c' in stack.

 4. While stack is not empty,
    pop each character stored inside stack and check if HashMap.containsKey(Character.getNumericValue(c)).
    - If it's true, Do 'flipped' += HashMap.get(Character.getNumericValue(c)).
        If current char is the last item in stack and HashMap.containsKey(Character.getNumericValue(c)),
        set answer = true.
    Then continue.
    
    - If it's false, then break;
        
 5. If Integer.parseInt(flipped) == n, answer = false.
 6. return answer.
 */


class Solution {
    public boolean confusingNumber(int n) {
        boolean answer = false;
        
        String nStr = Integer.toString(n);
        String flipped = "";
        Stack<Character> stack = new Stack();
        HashMap<Integer, Integer> isAbleToFlip = new HashMap<>();
        
        isAbleToFlip.put(0, 0);
        isAbleToFlip.put(1, 1);
        isAbleToFlip.put(6, 9);
        isAbleToFlip.put(8, 8);
        isAbleToFlip.put(9, 6);
        
        for(int i = 0; i < nStr.length(); i++){
            stack.add(nStr.charAt(i));
        }
        
        while(!stack.isEmpty()){
            char current = stack.pop();
            int currentNum = Character.getNumericValue(current);
            if(isAbleToFlip.containsKey(currentNum)){
                flipped += Integer.toString(isAbleToFlip.get(currentNum));
                if(stack.isEmpty()){answer = true;}
            }
            else {
                break;
            }
        }
        
        if(answer && Integer.parseInt(flipped) == n){
            answer = false;
        }
        
        return answer;
    }
}