class Solution {
    public boolean isSubsequence(String s, String t) {
        //이걸 어떻게 dp로 푸는지 알면 edit distance를 풀기에도 수월할듯-> 아님 얘는 완전일치해야해서...냅색인듯 싶기도 하고 그래...
        //왜냐하면 지금도 substring 방법밖에 생각 안 나거든
        //int [] dp = new int[s.length()];

        if(s.length()==0){
            return true;
        }

        if(s.length()==1){
            if(t.contains(s)){
                return true;
            }
            return false;
        }

        //가능한 한 앞에다 넣으면... 되지 않을까
        int index = 0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(index)){
                //dp[i] = index;
                index++;
            }
        }
        //근데 이것만 저장할거면 dp가 왜 굳이 필요하지 심지어 앞에 나온거 하나만 카운트하는데
        // if(dp[s.length()-1]!=0){
        //     return true;
        // }

        if(index==s.length()){
            return true;
        }
        return false;
    }
}