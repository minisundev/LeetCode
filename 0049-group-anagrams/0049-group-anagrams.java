class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            Map<Character,Integer> m = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                m.put(c,m.getOrDefault(c,0)+1);
            }
            StringBuilder sb = new StringBuilder();
            for(char c='a'; c<='z'; c++){
                sb.append(c).append(m.getOrDefault(c,0));
            }
            List<String> list = map.getOrDefault(sb.toString(),new ArrayList<>());
            list.add(s);
            map.put(sb.toString(),list);
        }
        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }
}