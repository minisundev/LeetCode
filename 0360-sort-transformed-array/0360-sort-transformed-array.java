class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        //이게 왜 투포인터 문제인지요...
        int [] answer = new int [nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            int i = a*num*num + b*num + c;
            pq.add(i);
        }

        int index = 0;
        while(!pq.isEmpty()){
            answer[index++] = pq.poll();
        }

        return answer;
    }
}