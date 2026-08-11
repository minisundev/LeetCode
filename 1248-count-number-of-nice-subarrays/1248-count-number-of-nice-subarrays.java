class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // 뒤에서부터 세어가지고 다음 odd의 주소 및 다음 odd의 개수를 가지고있기? -> k개 미만이 되는 순간 걍 드랍하기~
        // 하나가 odd이면 다음 odd의 주소를 가지고 있다가 거기로 점프하면서 세면 될것같기도
        int answer = 0;

        List<Integer> index = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(n%2!=0){//odd
                index.add(i);
            }
        }

        if(index.size() < k){ return 0; }

        int max = index.size()-(k-1);

        for(int i=0; i<max; i++){
            int leftIdx = index.get(i);
            int rightIdx = index.get(i+k-1);

            // 맨 처음인 것 처리
            int leftNumber = 0;
            if(i!=0){// 맨 처음이 아니라면
                leftNumber = leftIdx - index.get(i-1) -1;
            }else{
                leftNumber = leftIdx;
            }

            // 맨 마지막인 것 처리?
            int rightNumber = 0;
            if(i!=max-1){
                rightNumber = index.get(i+k) - rightIdx -1;
            }else{
                rightNumber = nums.length-1 - rightIdx;
            }

            // 그래서 조합할 수 있는 것의 길이가... 일단 k개는 포함이니까 본통은 다 포함이고
            // 앞뒤로 조합가능함 그 숫자임

            int number = (leftNumber+1) * (rightNumber+1);
            answer += number;

            //System.out.print(leftIdx +"-"+rightIdx+ " -> ");
            //System.out.println(leftNumber +","+rightNumber+ " number:"+number);
        }

        return answer;
    }
}