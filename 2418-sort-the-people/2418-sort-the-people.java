class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<names.length; i++){
            map.put(i,heights[i]);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1,o2)->
            o2.getValue()-o1.getValue()
        );

        String [] answer = new String[names.length];
        
        for(int i=0; i<list.size(); i++){
            Map.Entry<Integer,Integer> entry = list.get(i);
            answer[i] = names[entry.getKey()];
        }

        return answer;
    }
}