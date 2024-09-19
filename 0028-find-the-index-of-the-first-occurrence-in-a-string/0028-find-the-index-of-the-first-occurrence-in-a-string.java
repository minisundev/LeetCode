class Solution {
    public int strStr(String haystack, String needle) {

        
        for(int i=0; i<haystack.length(); i++){
            int h = i;
            int n = 0;
            while(h<haystack.length() && n<needle.length() &&haystack.charAt(h)==needle.charAt(n)){
                n++;
                h++;
            }
            if(n==needle.length()){
                return i;
            }
        }
        return -1;
    }
}