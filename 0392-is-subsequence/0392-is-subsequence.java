/*
 [Idea]
 1) Set int 'remainingLength' - int type variable for storing remaining number of characters in String s.
    And initialize it as the length of String s.
 2) Iterate over String s. : Iterator 'i'
 3) Inside that iteration, iterate over String t. : Iterator 'j'
    a) If t.charAt(j) == s.charAt(i) : remainingLength--;
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int sRemain = s.length();
        int tLocator = -1; // Lastly visited index of String t.
        boolean answer = true;
        
        for(int i = 0; i < s.length(); i++){
            for(int j = tLocator + 1; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    sRemain--;
                    tLocator = j;
                    break;
                }
            }
            
            int tRemain = (t.length() - 1) - tLocator;
            // Case when fail 1 : If after checking t on current char of s and if remainig letters of t is less than s remaining,
            //                    Further search is hopeless.
            if(tRemain < sRemain){answer = false;}
        }
        
        // Case when fail 2: If all the iteration which comparing s and t is over and if there's still remained chars in s,
        //                   It means that s is not a subsequence of t.
        if(sRemain != 0){answer = false;}
        
        return answer;
        
    }
}