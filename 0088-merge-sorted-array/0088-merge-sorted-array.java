class Solution {
    public void merge(int[] answer, int m, int[] nums2, int n) {
        int i = m - 1;          // answer의 유효 데이터 끝
        int j = n - 1;          // nums2 끝
        int k = m + n - 1;      // answer의 마지막 위치

        while (i >= 0 && j >= 0) {
            if (answer[i] > nums2[j]) {
                answer[k--] = answer[i--];
            } else {
                answer[k--] = nums2[j--];
            }
        }

        // nums2가 남아있는 경우
        while (j >= 0) {
            answer[k--] = nums2[j--];
        }
    }
}
