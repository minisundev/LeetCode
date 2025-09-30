class Solution {

    Map<Long,Long> counts = new HashMap<>();
    
    public long findMaximumNumber(long k, int x) {
    
        long low = 1;
        long high = 10_000_000_000_000_000L; //키워야만했다 ㅜ
        long result = 0;
        
        while(low<=high){
            long mid = low+(high-low)/2; //num 후보
            long sum = 0;
            
            // 1부터 mid까지 accumulated price 계산
            sum = getAccumulatedPrice(mid, x);

            if(sum<=k){//작으면 키워봐야지
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return result;
        
    }

    // 1부터 num까지의 accumulated price
    long getAccumulatedPrice(long num, int x) {
        long total = 0;
        
        //x배수 위치만 확인하기~
        for(int pos = x; pos <= 60; pos += x) {
            total += countOnesAtPosition(num, pos);
        }
        
        return total;
    }

    //1인 비트의 개수를..구해보자 ㅜ
    long countOnesAtPosition(long num, int position) {
        //long cycle = (long) Math.pow(2, position);
        long cycle = 1L << position; // 2^position을 더 빠르게...
        long cycleNumber = (num + 1) / cycle;//0부터 세어버려서 num+1을 해줌
        long count = cycleNumber * (cycle / 2);//1의 개수는 주기의 절반!
        
        long remainder = (num + 1) % cycle;//주기 다 못돌고 남은거 처리
        long halfCycle = cycle / 2;
        
        if(remainder > halfCycle) {//절반을 넘은만큼 1이 된다니까? 000111 이런식이니까
            count += remainder - halfCycle;
        }
        
        return count;
    }
}