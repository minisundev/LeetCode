class Solution {
    public boolean isValid(String s) {
        Deque<Character> d = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){//open
                d.addLast(c);
                //System.out.println("add "+ c);
            }else{//close
                if(d.isEmpty()) return false;
                char c2 = d.pollLast();
                //System.out.println("remove "+ c2);
                boolean pass = false;
                if(c==')' && c2=='('){
                    pass = true;
                }else if(c=='}' && c2=='{'){
                    pass = true;
                }else if(c==']' && c2=='['){
                    pass = true;
                }
                if(!pass) return false;
            }
        }
        if(!d.isEmpty()) return false;
        return true;
    }
}