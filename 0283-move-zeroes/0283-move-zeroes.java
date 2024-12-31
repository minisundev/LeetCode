class Solution {
    public void moveZeroes(int[] nums) {

        int index = 0;
        int zeroes = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }else{
                zeroes++;
            }
        }

        for(int i=nums.length-zeroes; i<nums.length; i++){
            nums[i] = 0;
        }

    }
}