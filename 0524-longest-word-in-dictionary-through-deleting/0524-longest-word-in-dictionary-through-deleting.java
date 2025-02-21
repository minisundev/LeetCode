import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String maxString = "";
        int max = 0;

        for (String str : dictionary) {
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (length < str.length() && str.charAt(length) == s.charAt(i)) {
                    length++;
                }
            }

            if (length == str.length()) {
                if (length > max) {
                    max = length;
                    maxString = str;
                } else if (length == max) {
                    if (str.compareTo(maxString) < 0) {
                        maxString = str;
                    }
                }
            }
        }
        return maxString;
    }
}
