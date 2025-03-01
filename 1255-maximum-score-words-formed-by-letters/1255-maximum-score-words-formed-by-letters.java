class Solution {

    int [] counts;
    int [] score;
    String [] words;
    int max = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        counts = new int [26];//어느 알파벳을 몇 개를 쓸 수 있는지 count함
        for(char c : letters){
            int count = counts[c-'a'];
            count++;
            counts[c-'a'] = count;
        }

        this.words = words;
        this.score = score;

        // 이거 마찬가지로 냅색 dp처럼 넣고빼고인거야 라고 생각하지 말고 최대한 생각해서 이건 끝까지 풀어내보자...
        search(0,0);

        return max;
    }

    //dfs로 풀어볼게!
    void search(int index, int sum){
        if(index==words.length){
            max = Math.max(max,sum);
            return;
        }
        // 포함하지 않는 경우의 수
        search(index+1,sum);

        // 포함하는 경우의 수
        int s = calculateScore(words[index]);
        if(s>=0){
            search(index+1,sum+s);
        }
        resetScore(words[index]);
    }

    int calculateScore(String s){
        int point = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            counts[c-'a'] = counts[c-'a']-1;
            if(counts[c-'a']<0){
                point = -1;
            }else if(point!=-1){
                point += score[c-'a'];
            }
        }
        return point;
    }

    void resetScore(String s){
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            counts[c-'a'] = counts[c-'a']+1;
        }
    }
}