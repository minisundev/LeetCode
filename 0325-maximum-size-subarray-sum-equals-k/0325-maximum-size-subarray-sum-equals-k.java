class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0,0);

        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            int left = map.getOrDefault(sum-k, Integer.MAX_VALUE);
            if(left!=Integer.MAX_VALUE){
                if(max<right-left+1){
                    max = right-left+1;
                    //System.out.println("max:"+max+" right:"+right+" left:"+left);
                }
            }

            //put => 이미 sum 값이 있다면 넣지않음...왜냐면 나보다 작은것중에 제일 인덱스 작은걸 써야 최대 길이가 나오니까?
            int index = map.getOrDefault(sum, Integer.MAX_VALUE);
            if(index==Integer.MAX_VALUE){
                map.put(sum,right+1);
            }
        }

        return max;
    }
}