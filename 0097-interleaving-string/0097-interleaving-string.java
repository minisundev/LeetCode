class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() == 0)
            return true;

        // 나는 String dp가 제일 어렵다고 생각해..
        if(s1.equals("") || s1 == null){
            if(s2.equals(s3)) return true;
            return false;
        }
        if(s2.equals("") || s2 == null){
            if(s1.equals(s3)) return true;
            return false;
        }
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // 매 칸을 채울때마다 선택지가 있어 s1에서 고를것이냐 s2에서 고를것이냐
        // 둘 중 무엇을 골라도 s3가 될 수 없으면 망한 분기점인거라 return false
        boolean fullMatch = false;
        Stack<State> stack = new Stack<State>();

        s1 = s1+" ";
        s2 = s2+" ";

        if (s1.charAt(0) == s3.charAt(0)) {
            stack.push(new State(1, 0, 1));
        }
        if (s2.charAt(0) == s3.charAt(0)) {
            stack.push(new State(0, 1, 1));
        }
        while (!stack.isEmpty()) {
            State state = stack.pop();

            if (state.i1 + 1 <= s1.length() && s1.charAt(state.i1) == s3.charAt(state.i3)) {
                if (state.i3 + 1 >= s3.length()) {
                    fullMatch = true;
                    break;
                }
                stack.push(new State(state.i1 + 1, state.i2, state.i3 + 1));
                System.out.println((state.i1 + 1) + " " + (state.i2) + " " + (state.i3 + 1));
            }
            if (state.i2 + 1 <= s2.length() && s2.charAt(state.i2) == s3.charAt(state.i3) ) {
                if (state.i3 + 1 >= s3.length()) {
                    fullMatch = true;
                    break;
                }
                stack.push(new State(state.i1, state.i2 + 1, state.i3 + 1));
                System.out.println((state.i1 + 1) + " " + (state.i2) + " " + (state.i3 + 1));
            }

        }

        // s3의 길이만큼 s3와 일치하는 수가 있다면~
        return fullMatch;
    }
}

class State {
    public int i1;
    public int i2;
    public int i3;

    public State(int i1, int i2, int i3) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
    }
}