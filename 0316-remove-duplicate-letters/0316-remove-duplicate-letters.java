class Solution {
    public String removeDuplicateLetters(String s) {
        //it can't be acheived without monotonic stack... ;-; so sad

        //final index
        Map<Character,Integer> lastIndex = new HashMap<>();
        for(int i=0;i<s.length();i++){
            lastIndex.put(s.charAt(i),i);
        }

        //결과 스택(문자만 저장함...)
        Deque<Character> stack = new ArrayDeque<>();
        //스택에 이미 들어있는지 체크를 해야 함~
        Set<Character> inStack = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            //이미 스택에 있으면 스킵
            if(inStack.contains(c)) continue;

            //current character < top && top appears later => pop
            while(!stack.isEmpty()
                && stack.peekLast() > c
                && lastIndex.get(stack.peekLast())>i
            ){
                char target = stack.pollLast();
                inStack.remove(target);
            }

            stack.offerLast(c);
            inStack.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);

        return sb.toString();


    }
}