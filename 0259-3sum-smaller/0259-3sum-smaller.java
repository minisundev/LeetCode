class Solution {
    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);
        
        int count = 0;
        
        loop:
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){

                int low = j+1;
                int high = nums.length-1;

                if(nums[i]+nums[j]+nums[low]>=target){
                    continue;
                }

                //k의 upperbound를 찾아야함
                while(low<=high){
                    int mid = (low+high)/2;
                    if(nums[i]+nums[j]+nums[mid]<target){//작을때까지는 올려봐도되고
                        low = mid+1;  
                    }else{//크거나같으면 내려야 함
                        high = mid-1;
                    }  
                }

                int increment = high-(j);
                //System.out.println(i+","+j+","+high+":"+increment);
                if(increment>0){
                    count += increment;
                }
            }
        }
        return count;
    }
}