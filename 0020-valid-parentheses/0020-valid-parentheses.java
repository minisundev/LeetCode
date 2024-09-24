import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            System.out.println("c"+c);

            if(c=='('||c=='{'||c=='['){
                stack.add(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                System.out.println("pop"+pop);
                if(c==')' && pop!='('){
                    return false;
                }
                if(c=='}' && pop!='{'){
                    return false;
                }
                if(c==']' && pop!='['){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}