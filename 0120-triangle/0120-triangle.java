import java.lang.Math;
import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //점화식 dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j],없으면 Integer.maxValue)+triangle[i][j];
        List<Integer> dp = new ArrayList<>();
        List<Integer> next;
        dp.add(triangle.get(0).get(0));

        for(int i=1; i<triangle.size(); i++){
            List<Integer> row = triangle.get(i);
            next = new ArrayList<>();
            for(int j=0; j<row.size(); j++){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(j-1>=0){
                    left = dp.get(j-1);
                }
                if(j<dp.size()){
                    right = dp.get(j);
                }

                next.add(Math.min(left,right)+row.get(j));
            }
            dp = next;
        }

        int min = Integer.MAX_VALUE;
        for(int i : dp){
            min = Math.min(min,i);
        }
        return min;
    }
}