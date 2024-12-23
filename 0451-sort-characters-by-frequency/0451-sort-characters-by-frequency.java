class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(O1,O2)->O2.getValue()-O1.getValue());

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : list){
            for(int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();

    }
}