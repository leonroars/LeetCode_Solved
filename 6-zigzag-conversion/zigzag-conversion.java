class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] arr = new StringBuilder[numRows];
        
        if(numRows == 1){return s;}
        
        int rowLocator = 0;
        boolean ascending = true;
        
        for(int i = 0; i < numRows; i++){arr[i] = new StringBuilder();}

        for(int idx = 0; idx < s.length(); idx++){
            arr[rowLocator].append(s.charAt(idx));
            if(idx != 0 && idx % (numRows - 1) == 0){ascending = !ascending;}

            if(ascending){rowLocator++;}
            else{rowLocator--;}
        }

        StringBuilder answer = new StringBuilder();

        for(int j = 0; j < numRows; j++){
            answer.append(arr[j]);
        }

        return answer.toString();
    }
}