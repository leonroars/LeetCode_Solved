class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Case I : str1.length() >= str2.length()
        if(str1.length() >= str2.length()) {return gcd(str1, str2);}

        // Case II : str1.length() < str2.length()
        return gcd(str2, str1);
    }

    // str.length() is always greater or equal to str2.length(). Enforced by caller.
    private String gcd(String str1, String str2){
        // Edge Case : Co-prime -> return empty string.
        if(isCoprime(str1, str2)){return "";}

        // General Cases.
        if(str2.isBlank() || str2.isEmpty()){return str1;}
        return gcd(str2, modulo(str1, str2));
    }

    
    private String modulo(String str1, String str2){
        return str1.replaceAll(str2, "");
    }

    private boolean isCoprime(String str1, String str2){
        return (!str1.contains(str2)) || (!str1.substring(0, str2.length()).equals(str2));
    }
}