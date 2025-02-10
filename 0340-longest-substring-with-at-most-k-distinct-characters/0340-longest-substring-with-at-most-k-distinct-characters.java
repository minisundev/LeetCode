class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k == 0)
            return 0;

        int max = 0;
        int from = 0;
        Map<Character, Letter> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // 새로운게 하나 나오면 이전에 나왔던 알파벳이 있는 위치까지 찾아가서 싹 제거 -> 저장을 final index로 해두자
            char c = s.charAt(i);
            Letter letter = map.getOrDefault(c, null);
            //System.out.print("i: " + i + " c: " + c + " ");

            if (letter == null) {
                //System.out.print("letter가 존재하지 않는다면 ~");

                if (map.size() < k) {
                    //System.out.print("map이 k 이하라면! ");
                    map.put(c, new Letter(i));
                    max = Math.max(max, i - from);
                    //System.out.println("from: " + from + "max: " + max);
                    continue;
                }
                
                while(map.get(s.charAt(from)).lastIndex!=from){
                    from++;
                }
                from++;
                map.remove(s.charAt(from-1));

                map.put(c, new Letter(i));
                max = Math.max(max, i - from);
                //System.out.println(" from: " + from + "max: " + max);
                continue;
            }

            // letter가 존재한다면~
            letter.lastIndex = i;
            //System.out.print(" lastIndex updated for char " + c + " to " + i);
            //map.put(c, letter);
            max = Math.max(max, i - from);
            //System.out.println(" i: " + i + " from: " + from + "max: " + max);
        }

        return max + 1;
    }
}

class Letter {
    public int lastIndex;

    public Letter(int lastIndex) {
        this.lastIndex = lastIndex;
    }












}