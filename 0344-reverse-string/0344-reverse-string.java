class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<=right){
            swap(s,left,right);
            left++;
            right--;
        }
    }

    void swap(char [] s, int i1, int i2){
        char c = s[i1];
        s[i1] = s[i2];
        s[i2] = c;
    }
}