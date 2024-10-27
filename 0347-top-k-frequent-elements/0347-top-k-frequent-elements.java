import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //일단 버킷 안 쓰고 그냥 생각나는대로 풀어봄
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,
        (e1,e2)->
            e2.getValue()-e1.getValue()
        );

        int [] answer = new int[k];

        for(int i=0; i<k; i++){
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}