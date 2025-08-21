import java.util.*;

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;

        int lo = 0;
        int hi = price[n - 1] - price[0];

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (canPick(price, k, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean canPick(int[] price, int k, int gap) {
        int count = 1;
        int last = price[0];
        for (int i = 1; i < price.length && count < k; i++) {
            if (price[i] - last >= gap) {
                count++;
                last = price[i];
            }
        }
        return count >= k;
    }
}
