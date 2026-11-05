class Solution {
    public int subarraySum(int[] nums, int k) {
        //  음수가 들어갈 수 있으면 이게 또 누적합의 투포인터도 아닌것 같은데~
        int count = 0;

        if(nums.length==1){
            if(nums[0]==k) return 1;
            return 0;
        }

        int [] sums = new int [nums.length+1];
        sums[0] = 0;
        sums[1] = nums[0];
        for(int i=0; i<nums.length; i++){
            sums[i+1] = sums[i] + nums[i];

            for(int j=0; j<=i; j++){
                if(sums[i+1]-sums[j]==k){
                    count++;
                    //System.out.println((i+1)+" to "+j);
                }
            }
        }

        return count;
    }
}