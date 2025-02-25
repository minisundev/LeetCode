class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // 각 문자의 마지막 등장 인덱스
        boolean[] used = new boolean[26]; // 결과에 이미 사용된 문자인지 체크
        
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            if (used[idx]) continue;
            
            //현재 char보다 크고 나중에 또 나오는 애는 제거,
            //현재 char보다 작거나 나중에 다시 안 나오는 애는 쓰기
            while (!stack.isEmpty() && 
                   stack.peek() > c && 
                   lastIndex[stack.peek() - 'a'] > i) {
                used[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            used[idx] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}