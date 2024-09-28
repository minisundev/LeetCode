class Solution {
    
    int [] count;

    public int jump(int[] nums) {
        count = new int[nums.length];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0] = 0;

        for(int i=0; i<nums.length; i++){
            int jump = nums[i];
            
            for(int j=0; j<=jump; j++){
                if(i+j<nums.length){
                    count[i+j] = Math.min(count[i]+1,count[i+j]);
                    //System.out.println((i+j)+": "+count[i+j]);
                }
            }
        }

        return count[count.length-1];
    }
}