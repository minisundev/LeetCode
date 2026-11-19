class FirstUnique {

    Map<Integer,Boolean> map = new HashMap<>();
    ArrayDeque<Integer> q = new ArrayDeque<>();

    public FirstUnique(int[] nums) {
        //ha unique
        //add 는 있고 remove는 없음 ㅎ
        //두개 이상이면 일단...
        for(int n : nums){
            add(n);
        }
    }
    
    public int showFirstUnique() {
        while(!q.isEmpty() && map.get(q.peekFirst())){
            q.pollFirst();
        }

        if(!q.isEmpty()){
            return q.peekFirst();
        }

        return -1;
    }
    
    public void add(int n) {
        Boolean b = map.getOrDefault(n,null);
        if(b==null){
            map.put(n,false);
            q.addLast(n);
        }else if(b==false){
            map.put(n,true);//2개 이상이면 이제 볼것도 없다...
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */