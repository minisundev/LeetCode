import java.util.*;

class Solution {
    public String reverseWords(String s) {
        String[] array = s.trim().split("\\s+");
        
        StringBuilder result = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            result.append(array[i]).append(" ");
        }
        
        return result.toString().trim();
    }
}
