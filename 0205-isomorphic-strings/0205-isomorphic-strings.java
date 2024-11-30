class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            int number = map.getOrDefault(s.charAt(i), map.size());
            sb.append(number).append(".");
            map.put(s.charAt(i), number);
        }
        String sNumber = sb.toString();

        sb = new StringBuilder();
        map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            int number = map.getOrDefault(t.charAt(i), map.size());
            sb.append(number).append(".");
            map.put(t.charAt(i), number);
        }
        String tNumber = sb.toString();

        if(sNumber.equals(tNumber)){
            return true;
        }
        return false;
    }
}