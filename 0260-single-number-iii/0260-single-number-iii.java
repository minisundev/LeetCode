class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.contains(i)){
                set.add(i);
            }else{
                set.remove(i);
            }
        }
        int [] answer = new int [2];
        int index = 0;
        for(int i : new ArrayList<>(set)){
            answer[index++] = i;
        }
        return answer;
    }
}