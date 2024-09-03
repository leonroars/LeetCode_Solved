class Solution {
    public String mergeAlternately(String word1, String word2) {
        String answer = "";
        
        int longerLength = (word1.length() > word2.length()) ? word1.length() : word2.length();
        
        for(int i = 0; i < longerLength; i++){
            if(i < word1.length()){
                answer += Character.toString(word1.charAt(i));
            }
            if(i < word2.length()){
                answer += Character.toString(word2.charAt(i));
            }
        }
        
        return answer;
    }
}