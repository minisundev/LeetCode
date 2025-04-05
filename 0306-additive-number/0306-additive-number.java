class Solution {
    boolean result = false;

    public boolean isAdditiveNumber(String num) {
        set1(num);
        return result;
    }

    void set1(String num) {
        int s1 = 0;
        int e1 = 1;
        if(num.charAt(s1) == '0' && e1 > s1 + 1) return;
        while(e1 <= num.length() - 1) {
            set2(num, s1, e1);
            e1++;
            if(result) return;
        }
    }

    void set2(String num, int s1, int e1) {
        int s2 = e1;
        int e2 = s2 + 1;
        if(num.charAt(s2) == '0' && e2 > s2 + 1) return;
        while(e2 <= num.length() - 1) {
            set(num, s1, e1, s2, e2);
            e2++;
            if(result) return;
        }
    }

    void set(String num, int s1, int e1, int s2, int e2) {
        if(num.charAt(s1) == '0' && e1 > s1 + 1) return;
        if(num.charAt(s2) == '0' && e2 > s2 + 1) return;
        if(e2 == num.length()) {
            return;
        }
        int s3 = e2;
        int e3 = s3 + 1;
        while(e3 <= num.length()) {
            int sumResult = sum(num.substring(s1, e1), num.substring(s2, e2), num.substring(s3, e3));
            if(sumResult == 0) {
                if(e3 == num.length()){
                    result = true;
                    return;
                }
                set(num, s2, e2, s3, e3);
                if(result) return;
            }
            e3++;
        }
    }

    int sum(String s1, String s2, String s3) {
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        int i3 = s3.length() - 1;
        int carry = 0;
        while(i1 >= 0 || i2 >= 0 || carry > 0){
            if(i3 < 0) return -1;
            int n1 = (i1 >= 0) ? (s1.charAt(i1--) - '0') : 0;
            int n2 = (i2 >= 0) ? (s2.charAt(i2--) - '0') : 0;
            int s = n1 + n2 + carry;
            carry = s / 10;
            int digit = s % 10;
            if(digit != (s3.charAt(i3--) - '0')) {
                return -1;
            }
        }
        if(i3 >= 0) return -1;
        return 0;
    }
}
