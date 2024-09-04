

/*
    Idea
     - Trim the given string. Which means, remove space at the very first and last of given string.
     - And do .split(" "). From that, we can get an array which contains word-separated string array.
     - But there can be multiple spaces between words.
        In such case, certain word in array can look like this : "  word "
     - Thus, when we iterate through that array from tail to head,
        we're going to deal with such spaces by performing .trim() to every each word of array.
     - After trimming each word, then we concatenate.
     - Make sure a single space inserted between each iteration.
 */

class Solution {
    public String reverseWords(String s) {
        String trimmed = s.trim();
        String[] arr = trimmed.split(" ");
        
        String answer = "";
        
        for(int i = arr.length - 1; i >= 0; i--){
            String stripped = arr[i].replaceAll(" ", "");
            System.out.println(stripped);
            answer += stripped;
            if(i > 0 && !stripped.equals("")){
                answer += " ";
            }
        }
        
        return answer;
    }
}