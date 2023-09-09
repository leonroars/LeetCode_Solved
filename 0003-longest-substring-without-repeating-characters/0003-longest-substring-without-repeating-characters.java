class Solution {
    public int lengthOfLongestSubstring(String s) {
        String[] sArr = s.split("");
        List<String> subList = new ArrayList<>();
        int currentMaxLen = 0;
        
        if(s.length() > 1){
            for(int i = 0; i < sArr.length - 1; i++){
                subList.add(sArr[i]);
                for(int j = i + 1; j < sArr.length; j++){
                    if(subList.contains(sArr[j])){
                        if(currentMaxLen < subList.size()){
                            currentMaxLen = subList.size();
                            break;
                        } else {break;}
                    } else {
                        subList.add(sArr[j]);
                        if(currentMaxLen < subList.size()){
                            currentMaxLen = subList.size();
                        }
                    }
                }
                subList.clear();
            }
            
        } else {currentMaxLen = s.length();}
        
        return currentMaxLen;
    }
}