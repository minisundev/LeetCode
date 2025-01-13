class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0"; // 모든 숫자를 제거하는 경우
        
        StringBuilder sb = new StringBuilder();
        int remainLen = num.length() - k; // 최종적으로 필요한 길이
        int maxIdx = -1;
        
        while (sb.length() < remainLen) {
            char min = '9';
            int minIdx = maxIdx + 1;
            // 현재 위치부터 선택 가능한 범위까지 중 최소값 찾기
            int end = num.length() - (remainLen - sb.length()) + 1;
            for (int i = maxIdx + 1; i < end; i++) {
                if (min > num.charAt(i)) {
                    min = num.charAt(i);
                    minIdx = i;
                }
            }
            maxIdx = minIdx;
            sb.append(min);
        }
        
        String str = sb.toString();
        // 앞의 0 제거
        while (str.length() > 1 && str.charAt(0) == '0') {
            str = str.substring(1);
        }
        
        return str;
    }
}