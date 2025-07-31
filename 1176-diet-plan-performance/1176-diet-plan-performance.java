class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int total = 0;
        int point = 0;

        for(int i=0; i<calories.length; i++){
            total += calories[i];

            if(i>=k){
                total -= calories[i-k];
            }

            if(i>=k-1){
                if(total>upper) point++;
                if(total<lower) point--;
            }
        }

        return point;
    }
}