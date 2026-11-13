class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int [] answer = new int [n-k+1];

        if(nums.length==0){
            return new int []{-1};
        }

        if(nums.length==1 || k==1){
            return nums;
        }

        // sliding window인데 ascending인지 봐야하는거임, 합은 안 중요하고 마지막이 중요함
        // ascending일때 윈도우 안에 넣으면서 +1을 해서 표시할까~
        // 순서 깨지면 0부터 다시 시작해서 마지막 원소일때 window 총합이 k가 넘으면 
        // 윈도우 안에서는 acsending만 한거고 안 넘으면 중간에 0된거고~

        int window = 0;
        
        for(int i=1;i<k-1;i++){
            if(nums[i-1]+1==nums[i]){
                window++;
            }else{
                window = 0;
            }
        }
        
        for(int i=k-1;i<n;i++){
            if(nums[i-1]+1==nums[i]){
                window++;
            }else{
                window = 0;
            }

            if(window>=k-1){
                answer[i-(k-1)] = nums[i];
            }else{
                answer[i-(k-1)] = -1;
            }
        }

        return answer;
    }
}