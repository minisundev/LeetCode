import java.util.*;

class Solution {
    public boolean isStrobogrammatic(String num) {

        Map<Character,Character> map = new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('0','0');
        map.put('8','8');
        map.put('1','1');

        int left = 0;
        int right = num.length()-1;
        while(left<=right){
            char l = num.charAt(left++);
            char r = num.charAt(right--);

            if(map.getOrDefault(l,' ')!=r){
                return false;
            }
        }

        return true;
        
    }
}