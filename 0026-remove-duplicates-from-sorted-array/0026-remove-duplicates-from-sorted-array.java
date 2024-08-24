class Solution {
    public int removeDuplicates(int[] nums) {
        int last = nums[0];
        int number = 1;

        for(int i=1; i<nums.length; i++){
            int now = nums[i];

            if(now!=last){
                nums[number] = now;
                number++;
            }

            last = now;
        }

        return number;
    }
}