class Solution {
    public String decodeString(String s) {
        Stack<Repeat> stack = new Stack();
        // [ ] 괄호 사이를 처음 만나는 순간 가장 안쪽의 괄호부터 저장했다가 뽑아서 연산해야 해
        // 아 아무것도 풀리는게 없는데 이정도는 풀고 내리고 싶어...
        // 이거 그냥 가져다가 쓰면 안되나..? [ ]이 없을때까지 반복해서 해주하면 될 거 같은데 그냥...
        // 3[a2[c]] -> a2[c]a2[c]a2[c] -> accaccacc
        while (s.contains("[")) {

        StringBuilder number = new StringBuilder();
        StringBuilder newString = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    number.append(c);
                    continue;
                } else if (c == '[') {
                    int count = 1;
                    int end = i + 1;
                    while (count > 0) {
                        if (s.charAt(end) == '[') {
                            count++;
                        } else if (s.charAt(end) == ']') {
                            count--;
                        }
                        end++;
                    }

                    String target = s.substring(i+1,end-1);
                    newString.append(target.repeat(Integer.parseInt(number.toString())));

                    i = end-1;
                    number = new StringBuilder();
                }else{
                    newString.append(c);
                }
            }

            s = newString.toString();
        }

        return s;

    }

}

class Repeat {
    // public String pre;
    public String s;
    public int i;

    // public String post;
    public Repeat(String s, int i /* , String post,String pre */) {
        // this.pre = pre;
        this.s = s;
        this.i = i;
        // this.post = post;
    }
}