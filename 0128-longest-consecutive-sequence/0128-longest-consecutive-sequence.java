class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        //정렬문제가 아닌거야?
        //똑같은거는 스킵해야하네? 0 1 1 2 -> 0 1 2가 됨...

        Map<Integer,Integer> s_e = new HashMap<>();
        Map<Integer,Integer> e_s = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        // 저 덩어리로 만들어서 넣어버리는 것임....
        for(int num : nums){
            //이미 포함되어있는지 체크하고
            if(set.contains(num)) continue;
            set.add(num);

            Integer prev = e_s.getOrDefault(num-1,null);
            Integer post = s_e.getOrDefault(num+1,null);
            
            //전은 있고 후가 없으면 전에만 추가하고 끝 
            if(prev!=null && post==null){
                //start update
                s_e.put(prev,num);
                //end update
                e_s.remove(num-1);
                e_s.put(num,prev);
                //max
                max = Math.max(max, num - prev + 1);
                continue;
            }

            //전도 후도 없다면 새로 넣어줌
            if(prev==null && post==null){
                //start update
                s_e.put(num,num);
                //end update
                e_s.put(num,num);
                //max
                max = Math.max(max, 1);
                continue;
            }

            //전이 없고 후가 있다면 후에 포함
            if(prev==null && post!=null){
                //start update
                s_e.remove(num+1);
                s_e.put(num,post);
                //end update
                e_s.put(post,num);
                //max
                max = Math.max(max, post - num + 1);
                continue;
            }

            //전도 있고 후도 있다면 전과 후를 이음
            if(prev!=null && post!=null){
                //start update
                s_e.put(prev,post);
                //end update
                e_s.put(post,prev);
                //이러고나서 post안에 들어있는 모든 것들의 링크를 수정해야하는것이냐고 ㅜㅜ
                //start랑 end만 관리하고... 나머지는 include set으로 하자 다시 수정하자...
                //max
                max = Math.max(max, post - prev + 1);
            }
            
        }

        return max;
    }
}