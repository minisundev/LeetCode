class Solution {
    public int[] singleNumber(int[] nums) {
        //2개는 한번만 나타나고
        //다른것들은 2번씩 나타난대
        //1번씩만 나오는거 2개 찾으래 그럼 해쉬겟지 뭐
        //linear runtime complexity
        //only constant extra space
        //해쉬쓰래
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int [] arr = {list.get(0), list.get(1)};
        return arr;
    }
}