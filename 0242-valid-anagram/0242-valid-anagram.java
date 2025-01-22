class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = map.getOrDefault(c, 0);
            if (count == 0)
                return false;
            count--;
            if (count == 0) {
                //System.out.println("removed " + c);
                map.remove(c);
            }else{
                map.put(c, count);
            }
            
        }
        //System.out.println(map.size());
        if (map.isEmpty())
            return true;
        return false;
    }
}