import java.util.*;

class Solution {

    int [] arr;
    List<Integer> can;
    int goal;
    List<Integer> list = new ArrayList<>();

    List<Map.Entry<Integer,Integer>> mapList;

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //unique
        // Set<Integer> set = new HashSet<>();
        // for(int i : candidates){
        //     set.add(i);
        // }
        // can = new ArrayList(set);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i : candidates){
            int count = map.getOrDefault(i,0);
            count++;
            map.put(i,count);
        }
        mapList = new ArrayList(map.entrySet());

        //arr = candidates;
        goal = target;
        sum(-1,0);
        return answer;
    }

    // void sum(int max, int sum){
    //     if(sum == goal){
    //         answer.add(new ArrayList(list));
    //         return;
    //     }else if(sum > goal){
    //         return;
    //     }

    //     for(int i=max+1;i<can.size(); i++){
    //         list.add(can.get(i));
    //         sum(i,sum+can.get(i));
    //         list.remove(list.size()-1);
    //     }
    // }

    void sum(int max, int sum){
        if(sum == goal){
            answer.add(new ArrayList(list));
            return;
        }else if(sum > goal){
            return;
        }

        for(int i=max+1;i<mapList.size(); i++){
            Map.Entry<Integer,Integer> entry = mapList.get(i);
            int number = entry.getKey();
            int count = entry.getValue();

            for(int j=1; j<=count; j++){
                for(int k=1; k<=j; k++){
                    list.add(number);
                }
                sum(i,sum+number*j);
                for(int k=1; k<=j; k++){
                    list.remove(list.size()-1);
                }
            }
        }
    }
}