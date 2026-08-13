class Solution {
    public long countSubarrays(int[] nums, int k) {
        // 흠 이것도 사실상 진심 똑같은 문제네...
        long answer = 0;

        int [] index = new int [nums.length];
        int size = 0;

        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(n>max){
                size = 0;
                index[size] = i;
                max = n;
                size++;
            }else if(n==max){
                index[size] = i;
                size++;
            }
        }

        if(size < k){ return 0L; }

        int maximum = size-(k-1);

        for(int i=0; i<maximum; i++){
            int leftIdx = index[i];
            int rightIdx = index[i+k-1];
            int rightIdx2 = nums.length;
            if(i!=maximum-1){
                rightIdx2 = index[i+k];
            }

            // 앞쪽은 다 포함
            long leftNumber = leftIdx;

            // 맨 마지막인 것 처리 -> 얘만 조합이 생겨서 곱해주면 됨
            long rightNumber  = rightIdx2 - rightIdx -1;

            // 그래서 조합할 수 있는 것의 길이가... 일단 k개는 포함이니까 본통은 다 포함이고
            // 앞으로만 세어야 중복이 없음~

            long number = (leftNumber+1) * (rightNumber+1);
            answer += number;

            //System.out.print(leftIdx +"-"+rightIdx+ " -> ");
            //System.out.println(leftNumber +","+rightNumber+ " number:"+number+" answer:"+answer);
        }

        
        return answer;
    }
}