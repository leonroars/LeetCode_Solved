class Solution {
    public boolean isPalindrome(int x) {
        String xStr = Integer.toString(x);
        String xRev = new StringBuilder(xStr).reverse().toString();
        if(xStr.equals(xRev)){return true;}
        else{return false;}
    }
}