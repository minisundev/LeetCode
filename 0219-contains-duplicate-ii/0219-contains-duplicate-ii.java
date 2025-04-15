class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<=1) return false;
        //그냥 hash랑 슬라이딩 윈도우를 쓰자...
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<=k && i<nums.length; i++){
            int num = nums[i];
            int count = map.getOrDefault(num,0);
            count++;
            if(count>1){
                //System.out.println("count exceeded 1 at i: "+i);
                return true;
            } 
            map.put(num,count);
        }

        for(int i=k+1; i<nums.length; i++){
            //remove
            map.put(nums[i-k-1],map.getOrDefault(nums[i-k-1],0)-1);
            //add
            int num = nums[i];
            int count = map.getOrDefault(num,0);
            count++;
            if(count>1) {
                //System.out.println("count exceeded 1 at i: "+i);
                return true;
            }
            map.put(num,count);
        }
        return false;
    }
}