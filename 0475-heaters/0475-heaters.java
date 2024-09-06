import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // lowerbound
        int high = Integer.MAX_VALUE;
        int low = 0;

        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (high + low) / 2;
            
            if (checkIfHouseIsReady(mid, houses, heaters)) {
                min = Math.min(min,mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }

    boolean checkIfHouseIsReady(int range, int[] houses, int[] heaters) {
        int i = 0; // Pointer for houses
        
        for (int heater : heaters) {
            int left = heater - range;
            int right = heater + range;
            
            while (i < houses.length && houses[i] >= left && houses[i] <= right) {
                i++;
            }
        }
        return i == houses.length;
    }
}
