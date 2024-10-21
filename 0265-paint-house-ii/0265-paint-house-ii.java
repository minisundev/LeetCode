import java.util.*;
import java.lang.Math;

class Solution {
    public int minCostII(int[][] costs) {
        int houses = costs.length;
        if(houses == 0) return 0;
        int colors = costs[0].length;
        
        // dp 없이 최소값 추적만으로 해결
        int prevMin = 0, prevSecondMin = 0, prevColor = -1;

        for (int i = 0; i < houses; i++) {
            int currMin = Integer.MAX_VALUE, currSecondMin = Integer.MAX_VALUE, currColor = -1;
            
            for (int j = 0; j < colors; j++) {
                // 현재 집을 칠할 때 이전 집에서 동일한 색을 선택했는지 확인
                int cost = costs[i][j] + (j == prevColor ? prevSecondMin : prevMin);

                // 현재 집에서 최소값과 두 번째 최소값을 갱신
                if (cost < currMin) {
                    currSecondMin = currMin;
                    currMin = cost;
                    currColor = j;
                } else if (cost < currSecondMin) {
                    currSecondMin = cost;
                }
            }
            
            // 이전 집의 최소값들을 업데이트
            prevMin = currMin;
            prevSecondMin = currSecondMin;
            prevColor = currColor;
        }
        
        return prevMin;
    }
}
