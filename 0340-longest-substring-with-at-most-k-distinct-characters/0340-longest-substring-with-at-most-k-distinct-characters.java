class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k == 0)
            return 0;

        int max = 0;
        int from = 0;
        Map<Character, Letter> map = new HashMap<>();
        PriorityQueue<Letter> pq = new PriorityQueue<>(
            (o1,o2)->o1.lastIndex-o2.lastIndex
        );

        for (int i = 0; i < s.length(); i++) {
            // 새로운게 하나 나오면 이전에 나왔던 알파벳이 있는 위치까지 찾아가서 싹 제거 -> 저장을 final index로 해두자
            char c = s.charAt(i);
            Letter letter = map.getOrDefault(c, null);
            //System.out.print("i: " + i + " c: " + c + " ");

            if (letter == null) {
                //System.out.print("letter가 존재하지 않는다면 ~");

                if (map.size() < k) {
                    //System.out.print("map이 k 이하라면! ");
                    map.put(c, new Letter(i,c));
                    max = Math.max(max, i - from);
                    //System.out.println("from: " + from + "max: " + max);
                    continue;
                }

                char fromC = s.charAt(from);
                Letter fromLetter = findFirstFinalIndex(map);

                //System.out.print("move from to lastIndex " + fromLetter.lastIndex);
                from = fromLetter.lastIndex + 1;

                //System.out.println(" from: " + from + "max: " + max);
                map.remove(fromLetter.c);
                map.put(c, new Letter(i,c));
                max = Math.max(max, i - from);
                //System.out.println(" from: " + from + "max: " + max);
                continue;
            }

            // letter가 존재한다면~
            letter.lastIndex = i;
            //System.out.print(" lastIndex updated for char " + c + " to " + i);
            map.put(c, letter);
            max = Math.max(max, i - from);
            //System.out.println(" i: " + i + " from: " + from + "max: " + max);
        }

        return max + 1;
    }

    Letter findFirstFinalIndex(Map<Character, Letter> map){
        Letter firstFinalIndex = null;
        for(Map.Entry<Character, Letter> entry : map.entrySet()){
            if(firstFinalIndex==null || firstFinalIndex.lastIndex > entry.getValue().lastIndex){
                firstFinalIndex = entry.getValue();
            }
        }
        return firstFinalIndex;
    }
}

class Letter {
    public int lastIndex;
    public char c;

    public Letter(int lastIndex, char c) {
        this.lastIndex = lastIndex;
        this.c = c;
    }
}