class Solution {
    boolean result = false;
    List<String> wordDict;

    public boolean wordBreak(String s, List<String> wordDict) {
        //replace로 들어가는 냅색같은 dp일 거 같은데 worddict의 항목을 포함하고 안 하고 해서 끝까지 가봐야 할 거 같아서..?
        //포함함 포함하지않음 으로 0이 되거나 wordDict의 모든 항목을 돌았거나 하면 return 해야겠지
        //그러나 진ㅉ나 dp는 모르겠고 백트래킹밖에 모르겠다 
        //이따 가서 dp로 다시풀어봄
        this.wordDict = wordDict;
        search(0,s);
        return result;
    }

    void search(int index, String s){
        if(result){
            return;
        }
        if(s.length()==0){
            result = true;
            return;
        }
        if(index==wordDict.size()){
            return;
        }

        //포함
        search(index+1,s.replace(wordDict.get(index),""));

        //미포함
        search(index+1,s);
    }
}