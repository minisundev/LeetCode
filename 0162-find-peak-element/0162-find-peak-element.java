class Solution {
    public int findPeakElement(int [] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;

            int left = left(mid,nums);
            int right = right(mid,nums);
            int number = nums[mid];

            System.out.println(mid+":"+left+","+number+","+right);

            if(number>left && number>right){
                return mid;
            }else if(number>left){//only left is smaller -> move right
                low = mid+1;
            }else if(number>right){//only right is smaller
                high = mid-1;
            }else{//both are bigger
                low = mid+1;
            }
        }
        return 0;
    }

    int left (int index, int [] nums) {
        if(index>0){
            return nums[index-1];
        }else{
            return Integer.MIN_VALUE;
        }
    }

    int right (int index, int [] nums) {
        if(index<nums.length-1){
            return nums[index+1];
        }else{
            return Integer.MIN_VALUE;
        }
    }
}