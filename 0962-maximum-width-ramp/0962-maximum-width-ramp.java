class Solution {
    public int maxWidthRamp(int[] nums) {
        int max = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++){
            while(dq.isEmpty()||nums[dq.peekLast()]>nums[i]){
                dq.offerLast(i);
            }
        }

        while(!dq.isEmpty()){
            int index = dq.pollLast();
            for(int j=nums.length-1;j>index;j--){
                if(nums[j]>=nums[index]){
                    max = Math.max(max,j-index);
                    break;
                }
            }
        }

        return max;
    }
} 

