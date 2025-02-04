class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 1;
        // 정렬없이... 어디다가 삽입하면서 그게 원래 있던거랑 일치하면...merge를 해야하는데?
        // Hash에다가... 시작,끝 으로 저장한다고 쳐도 ㅜ 1 들어가ㅗㄱ 3 들어갔다가 2 들어가는걸 어케알건데 ㅎ'
        // 정렬 없이 어캐해요 이걸 . . . ? . . . . . . . ?
        // 시작하는 HashMap이랑 끝나는 HashMap을 동시에 관리해서 시작과 끝을 얘로 검색해서 둘 다 업데이트 치고 remove 하시면
        // 되겠습니다!!
        if(nums.length==0) return 0;
        
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        for (int i : nums) {
            if (!start.containsKey(i)) {
                if (end.containsKey(i - 1) && start.containsKey(i + 1)) {
                    end.put(start.get(i + 1), end.get(i - 1));
                    start.put(end.get(i - 1), start.get(i + 1));

                    max = Math.max(max, start.get(i + 1) - end.get(i - 1)+1);

                    end.remove(i - 1);
                    start.remove(i + 1);

                } else if(start.containsKey(i + 1)){
                    start.put(i, start.get(i + 1));
                    end.put(start.get(i + 1),i);

                    max = Math.max(max, start.get(i + 1) - i +1);

                    start.remove(i+1);

                }else if(end.containsKey(i - 1)){
                    end.put(i, end.get(i - 1));
                    start.put(end.get(i - 1),i);

                    max = Math.max(max, i - end.get(i - 1) +1);

                    end.remove(i-1);

                }else {
                    start.put(i, i);
                    end.put(i, i);
                }
            }
            //System.out.println("i: "+ i);
            //print(start);
        }
        return max;
    }

    void print(Map<Integer, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sb.append('<')
                    .append(entry.getKey())
                    .append(',')
                    .append(entry.getValue())
                    .append('>')
                    .append('\n');
        }
        System.out.println(sb);
    }
}