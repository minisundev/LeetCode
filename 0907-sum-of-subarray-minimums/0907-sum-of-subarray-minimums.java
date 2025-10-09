class Solution {
    public int sumSubarrayMins(int[] arr) {
        //모든 subarray들의 minimum=>subarray를 구해서 하면 당연히 시간초과가 나겠지요~~
        //그러면 한 원소가 들어가는 모든 subarray를 채우는 식으로 반대로 풀어야 할 것 같은데
        //i번째 원소에서 넣을 수 있는 subarray는 크기 1인 subarray => 반드시 해당, sum에 더해줌 
        //나 전의 나보다 더 작은 원소 => 를 모노토닉 스택으로 어케 관리할지도 문제임
        //나 후의 나보다 더 작은 원소 => 를 모노토닉 스택으로 어케 관리할지도 문제임
        //현재 시점에서 그걸 어떻게 알 수가 있지?

        int sum = 0;

        int divide = 1000_000_000 + 7;
        Deque<Integer> deq = new ArrayDeque<>();

        int [] left = new int [arr.length];

        for (int i = 0; i < arr.length; i++) {
            //내 앞으로 나보다 더 큰것들은 다 뽑음=> 나보다 작은 것의 인덱스가 나옴! => 그것을 저장...
            int n = arr[i];
            while(!deq.isEmpty()&&arr[deq.peekLast()]>n){
                deq.pollLast();
            }

            if(deq.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = deq.peekLast();
            }

            deq.offerLast(i);
        }

        deq.clear();

        for (int j = arr.length-1; j >= 0; j--) {
            //내 뒤로 나보다 더 큰것들은 다 뽑음=> 나보다 작은 것의 인덱스가 나옴!
            int n = arr[j];
            while(!deq.isEmpty()&&arr[deq.peekLast()]>=n){
                deq.pollLast();
            }

            int right;

            if(deq.isEmpty()){
                right = arr.length;
            }else{
                right = deq.peekLast();
            }

            long temp = (long)arr[j]*(j-left[j])*(right-j);
            temp = (sum+temp)% divide;

            sum = (int)temp;

            deq.offerLast(j);
        }

        return sum;
    }
}