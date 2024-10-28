import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        //버킷을 써서 정렬을 삭제함
        List<List<Integer>> buckets = new ArrayList(nums.length);
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>()); 
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        for(Map.Entry<Integer,Integer> entry : list){
            List<Integer> element = buckets.get(entry.getValue());
            element.add(entry.getKey());
        }


        int [] answer = new int[k];

        int index = 0;
        int target = nums.length;

        while(index<k){
            List<Integer> element = buckets.get(target);

            if(element!=null && !element.isEmpty()){
                for(int i=element.size()-1; i>=0; i--){
                    answer[index++] = element.get(i);
                    //element.remove(i); -> 굳이 안 해도 되는 remove 빼봄
                    if(index>=k){
                        break;
                    }
                }
            }
            target--;
        }

        return answer;
    }
}