class Solution {
    public boolean canBeEqual(String s1, String s2) {
        //다를때 2칸 후를 봐서 바꿔서 둘이 같아지면 넘어가고... 아니라면... 전은 왜 비교를 안하냐면 이미 같았기에 넘어왔을거니까 ㅎ
        boolean [] visit = new boolean[s1.length()];

        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);

            if(visit[i]){
                c1 = s1.charAt(i-2);
            }

            if(c1!=s2.charAt(i)){
                if(i+2<s1.length()){
                    if(s1.charAt(i+2)==s2.charAt(i)){
                        visit[i+2] = true;
                        continue;
                    }
                }
                return false;
            }
        }
        return true;
    }
}