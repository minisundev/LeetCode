import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list,
        (o1,o2)->{
            return o1.getKey() - o2.getKey();
        }
        );

        int index = 0;
        for(Map.Entry<Integer,Integer> entry : list){
            int count = entry.getValue();
            while(count>0 && index<nums.length){
                nums[index++] = entry.getKey();
                count--;
            }
        }
    }
}