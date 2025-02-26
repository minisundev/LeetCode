class Solution {
    public int minOperations(int[] nums) {
        int flip = 0;

        for(int n : nums){
            if((n==0&&flip%2==0 )||(n==1&&flip%2==1)){
                flip++;
            }
        }
        
        return flip;
    }
}