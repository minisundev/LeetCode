class Solution {
    public String smallestSubsequence(String s) {
        //슬라이딩 윈도우 넉김으로?
        //앞글자부터의 순서가... 지금부터의 순서보다 작다면 무조건 킵하고 붙이고
        //앞글자부터의 순서가 지금부터의 순서가 더 빠르다면 무조건 대체하면 되는거같은데
        //포인터 두개(비교시 임시로 두개 더..?) 써가지고말야 ㅇㅇ?
        
        int last = 0;
        int now = 1;
        while(now<s.length()){
            int lastIdx = last;
            int nowIdx = now;
            while(nowIdx<s.length()){
                if(s.charAt(lastIdx)>s.charAt(nowIdx)){
                    //작으면 당장교체해 ㅜ
                    last = now;
                    now = nowIdx;
                    System.out.println(s.charAt(lastIdx)+","+s.charAt(nowIdx));
                    break;
                }else if(s.charAt(lastIdx)==s.charAt(nowIdx)){
                    //같으면 유지하면서 더 가보세요...
                    System.out.println(s.charAt(lastIdx)+","+s.charAt(nowIdx));
                    nowIdx++;
                }else{//s.charAt(lastIdx)<s.charAt(nowIdx
                    now++;//다음 인덱스부터 비교시작...
                    System.out.println(s.charAt(lastIdx)+","+s.charAt(nowIdx));
                    break;
                }
                nowIdx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean [] visit = new boolean[26];
        for(int i=last; i<s.length(); i++){
            char c = s.charAt(i);
            if(!visit[c-'a']){
                sb.append(c);
                visit[c-'a'] = true;
            }
        }
        return sb.toString();
    }
}