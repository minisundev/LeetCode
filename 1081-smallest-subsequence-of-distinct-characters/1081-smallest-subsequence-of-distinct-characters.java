class Solution {
    public String smallestSubsequence(String s) {
        Map<Character,Integer> last = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            last.put(c,i);
        }

        Set<Character> contain = new HashSet<>();
        Deque<Character> dq = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(contain.contains(c)) continue;
            
            while(!dq.isEmpty()
            && dq.peekLast()>c
            && last.get(dq.peekLast())>i
            ){
                char removed = dq.pollLast();
                contain.remove(removed);
            }

            dq.offerLast(c);
            contain.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.pollFirst());//첫번째부터 뺄수가있어... dq의 승리다..!
        }
        return sb.toString();
    }
}