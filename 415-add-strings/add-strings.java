import java.util.Stack;

class Solution {
    /* 
       Considering the max string length of given inputs and constraints,
       I came up with an idea that actually adding numbers correspondingly with carry.
       In this way, the string length of result will have the size as much as 10^4 + 1.
     */

    public String addStrings(String num1, String num2) {

        // 1) Parse input numbers into char array with leading zeros.
        String[] formattedNumbers = formatNumbers(num1, num2);

        // 2) Simulates addition with carries.
        return simulatesAddition(formattedNumbers[0], formattedNumbers[1]);
        
    }

    public String[] formatNumbers(String num1, String num2) {
        int lengthDiff = Math.abs(num1.length() - num2.length());

        StringBuilder sb;

        if(num1.length() > num2.length()){
            sb = new StringBuilder();
            sb.append("0".repeat(lengthDiff));
            sb.append(num2);

            num2 = sb.toString();
        }
        else if(num1.length() < num2.length()){
            sb = new StringBuilder();
            sb.append("0".repeat(lengthDiff));
            sb.append(num1);

            num1 = sb.toString();
        }

        return new String[]{num1, num2};
    }

    public String simulatesAddition(String num1, String num2) {
        StringBuilder answer = new StringBuilder();

        boolean carry = false;
        int digitCnt = num1.length();
        int currentDigit = 1;

        while(currentDigit <= digitCnt){
            int num1Digit = Character.getNumericValue(num1.charAt(digitCnt - currentDigit));
            int num2Digit = Character.getNumericValue(num2.charAt(digitCnt - currentDigit));

            int sum = num1Digit + num2Digit;

            // Applying carry
            if(carry){sum += 1;}

            // Updating carry
            carry = (sum / 10 == 1) ? true : false;
            
            // Adds modulo into StringBuilder
            answer.append(sum % 10);

            // Updating currentDigit
            currentDigit++;
        }

        if(carry){answer.append(1);}

        return answer.reverse().toString();
    }
}