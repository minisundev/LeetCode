class Solution {
    int [] nums;
    List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        add(0,new ArrayList());
        return list;
    }

    void add(int index, List<Integer> sub){
        if(index==nums.length){
            list.add(sub);
            return;
        }

        //미포함
        add(index+1, new ArrayList(sub));

        //포함
        List<Integer> newSub = new ArrayList(sub);
        newSub.add(nums[index]);
        add(index+1,newSub); 
    }
}