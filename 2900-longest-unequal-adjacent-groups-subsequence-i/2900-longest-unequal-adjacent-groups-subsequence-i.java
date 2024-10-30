class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        //이거 그냥 longest increasing subsequence 찾는데 찾아가지고 groups에 있는 알파벳 읽어서 돌려보내는 문제잖아.........
        //이거 푼다고 edit distance를 풀 수가 없어요 아니면 내가 edit distance를 잘못 생각했나
        //이것도 dp도 필요없는데...? 이게 왜 dp문제야...?
        //문제를 이해를 못하셨어요 0 후에 1 후에 0이 나오는데 왜 3개를 다 출력하지
        //아하 인접한 인덱스가 달라야하는데 그냥 증가로 체크해버림

        List<String> list = new ArrayList<>();

        int number = groups[0];
        list.add(words[0]);

        for(int i=1;i<groups.length;i++){
            if(groups[i-1]!=groups[i]){
               list.add(words[i]);
            } 
        }

        return list;

        
    }
}