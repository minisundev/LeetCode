class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        //-일때 채널을 다르게 쓰면 될 것 같기도 하고...
        int plus = 0;
        int minus = 0;
        if(nums[0]>0){
            plus = nums[0];
        }else{
            minus = nums[0];
        }
        int max = nums[0];

        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            if(num>0){
                plus = Math.max(nums[i],plus*nums[i]);
                minus = Math.min(nums[i],minus*nums[i]);
                max = Math.max(max,plus);
                //System.out.println("i:"+i+" plus:"+plus+" minus:"+minus+" max:"+max);
            }else{
                int plusTemp = plus;
                plus = Math.max(nums[i],minus*nums[i]);
                minus = Math.min(nums[i],plusTemp*nums[i]);
                max = Math.max(max,plus);
                //System.out.println("i:"+i+" plus:"+plus+" minus:"+minus+" max:"+max);
            }
        }
        return max;
    }
}