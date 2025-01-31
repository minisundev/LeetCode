class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int n;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        combi(new ArrayList<>(), 0, k);
        return answer;
    }

    void combi(List<Integer> list, int max, int k){
        if(list.size()==k){
            answer.add(list);
            return;
        }

        for(int i=max+1; i<=n; i++){
            List<Integer> copy = new ArrayList<>(list);
            copy.add(i);
            combi(copy,i,k);
        }
    }
}