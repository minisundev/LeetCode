class Solution {
    public int[] dailyTemperatures(int[] arr) {
        //오큰수네.. 다음 더따뜻한 날..s..
        //없으면 0돌아감
        Deque<Integer> dq = new ArrayDeque<>();
        int [] answer = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int temp = arr[i];
            while(!dq.isEmpty() && arr[dq.peekLast()]<temp){
                int day = dq.pollLast();
                answer[day] = i-day;
            }
            dq.offerLast(i);
        }

        return answer;
    }
}