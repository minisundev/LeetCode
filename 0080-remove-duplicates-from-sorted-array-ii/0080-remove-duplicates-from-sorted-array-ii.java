class Solution {
    public int removeDuplicates(int[] nums) {
        //이게ㅜ왜 투포인터지...단방향밖에 떠오르지 않아
       int index = 0;
       int last = Integer.MIN_VALUE;
       int count = 0;
       for(int i=0; i<nums.length; i++){
        int num = nums[i];
        if(last==num){
            if(count<1){
                count++;
                nums[index++] = num;
            }
        }else{
            count = 0;
            nums[index++] = num;
        }
        last = num;
       }

       return index;
    }
}