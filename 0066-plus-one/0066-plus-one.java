class Solution {
    public int[] plusOne(int[] digits) {
        int increment = 0;

        if(digits[digits.length-1]+1>=10){
            digits[digits.length-1] = digits[digits.length-1]+1-10;
            increment = 1;
        }else{
            digits[digits.length-1] = digits[digits.length-1]+1;
        }


        for(int i=digits.length-2;i>=0;i--){
            int element = digits[i];
            if(element+increment>=10){
                digits[i] = element+increment-10;
                increment = 1;
            }else{
                digits[i] = element+increment;
                increment = 0;
            }
        }

        if(increment==1){
            int [] result = new int[digits.length+1];
            result[0] = 1;
            for(int i=0;i<digits.length;i++){
                result[i+1] = digits[0];
            }
            return result;
        }
        return digits;
    }
}