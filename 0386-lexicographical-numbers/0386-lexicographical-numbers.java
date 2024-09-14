class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            answer.add(i);
        }

        Collections.sort(answer,
        (o1,o2)->
        {
            return Integer.toString(o1).compareTo(Integer.toString(o2));
        });

        return answer;
    }
}