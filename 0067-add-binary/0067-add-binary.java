class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int aIdx = a.length()-1;
        int bIdx = b.length()-1;
        int increment = 0;

        while(aIdx>=0||bIdx>=0){
            if(aIdx<0){
                int number = (b.charAt(bIdx)-'0')+increment;
                if(number>=2){
                    increment = 1;
                    number = number-2;
                }else{
                    increment = 0;
                }
                System.out.println(number+","+increment);
                result = number+result;
                bIdx--;
            }else if(bIdx<0){
                int number = (a.charAt(aIdx)-'0')+increment;
                if(number>=2){
                    increment = 1;
                    number = number-2;
                }else{
                    increment = 0;
                }
                System.out.println(number+","+increment);
                result = number+result;
                aIdx--;
            }else{
                int number = (b.charAt(bIdx)-'0')+(a.charAt(aIdx)-'0')+increment;
                if(number>=2){
                    increment = 1;
                    number = number-2;
                }else{
                    increment = 0;
                }
                System.out.println(number+","+increment);
                result = number+result;
                aIdx--;
                bIdx--;
            }
        }
        if(increment==1){
            result = increment+result;
        }
        return result;
    }
}