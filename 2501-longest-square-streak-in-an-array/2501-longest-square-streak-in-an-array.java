class Solution {
    public int longestSquareStreak(int[] nums) {
        //아 sort한다음에 HashMap에다가 등록시켜서 다음 원소 있는지..보기?
        //sort가 더 오래 걸리니까 그냥 for문 하나 돌려서 다 등록하고... 보기?
        Arrays.sort(nums);
        //한번 돌면서 비었거나 list의 아무 square에도 해당하지 않는 경우 list에 추가
        //list는 stack으로 이루어져 있고~ 마지막 원소 peek 해서 제곱이면 집어넣고~ size()의 max를 리턴해보자~~
        //아 너무 느리니까 마지막 원소의 Map으로 바꿔봄~
        Map<Integer,Integer> map = new HashMap<>();//뭐가 앞에 있었는지는 모르겠고 현재까지 streak 길이만 저장한다~
        int max = 0;
        for(int num: nums){
            //쪼개지는 경우
            //맵에 있는 경우~
            int sqrt = (int)Math.sqrt(num);
            if(sqrt * sqrt == num){
                int count = map.getOrDefault(sqrt,0);
                if(count!=0){//맵에 있는 경우
                    map.put(num,count+1);
                    max = Math.max(max,count+1);
                    continue;
                }
            }
            //맵에 없는 경우~
            map.put(num,1);
            max = Math.max(max,1);    
        }

        if(max == 1) return -1;
        return max;
    }
}