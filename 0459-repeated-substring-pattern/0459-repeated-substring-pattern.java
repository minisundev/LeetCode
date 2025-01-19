class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()<=1){
            return false;
        }
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}