class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //흠 이거 오큰수 문제잖아
        int [] answer = new int [temperatures.length];

        Deque<Integer> d = new ArrayDeque<>();

        for(int i=0; i<temperatures.length; i++){
            int t = temperatures[i];
            while(!d.isEmpty() && temperatures[d.peekLast()]<t){
                int index = d.pollLast();
                answer[index] = i-index;
            }
            d.offerLast(i);
        }

        return answer;
    }
}