class Solution {
    

    public String removeKdigits(String num, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<num.length(); i++){
            int n = num.charAt(i)-'0';
            
            while(!dq.isEmpty()
                && dq.peekLast()>n // 지금 peek가 지금 n보다 크고
                && dq.size()+(num.length()-i)>num.length()-k// 뒤에 넣을수있는게 남아있으면(peek 뽑고 다시 넣는거 포함)
            ){
                dq.pollLast();//뽑기
            }
            //뒤에 넣을수있는게 안 남아있으면 그냥 나오는거 다 넣어야함 ㅎ...
            if(dq.isEmpty() && n==0 && num.length()-k!=1) continue;
            if(dq.size()<num.length()-k) dq.offerLast(n);
        }

        StringBuilder sb = new StringBuilder();
        if(dq.isEmpty()){
            return "0";
        }
        while(!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}