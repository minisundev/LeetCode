class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int [] answer = new int [queries.length];
        //아 누적합 문제인거 같기도 하고요~
        //일단 *개수 세는 배열이 있고
        //쿼리 들어오면 왼쪽~오른쪽부터 봐가지고 투포인터 형식으로? |로 둘러싸인 개수를 구하는것임...
        int [] plates = new int [s.length()];
        int [] lastCandle = new int [s.length()];
        int [] nextCandle = new int [s.length()];

        plates[0] = s.charAt(0)=='*' ? 1 : 0;
        
        int last = -1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)=='*'){
                plates[i] = plates[i-1]+1;
                lastCandle[i] = last;
                nextCandle[i] = -1;
            } else{
                plates[i] = plates[i-1];
                if(last!=-1){
                    nextCandle[last] = i;
                }
                last = i;
                lastCandle[i] = last;
            }
        }

        for(int i=0; i<queries.length; i++){
            int [] q = queries[i];
            int left = q[0];
            int right = q[1];

            while(s.charAt(left)!='|' && left<right){
                if(lastCandle[left]!=-1){
                    left = nextCandle[lastCandle[left]];
                }else{
                    left++;
                }
                
            }
            
            while(s.charAt(right)!='|' && left<right){
                right = lastCandle[right];
            }

            if(left!=right){
                answer[i] = plates[right]-plates[left];
            }

        }
        return answer;
    }
}