class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int [] arr;
    boolean [] visit;
    Set<String> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        arr = nums;
        visit = new boolean[arr.length];
        dfs(new ArrayList<>(),-1);
        return answer;
    }

    void dfs(List<Integer> list, int max){
        if(check(list)){
            answer.add(list);
        }
        if(list.size()==arr.length){
            return;
        }

        for(int i=max+1; i<visit.length; i++){
            if(!visit[i]){
                visit[i]=true;
                List<Integer> copy = new ArrayList<>(list);
                copy.add(arr[i]);
                dfs(copy,i);
                visit[i]=false;
            }
        }
    }

    String toString(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append('-');
        }
        return sb.toString();
    }

    boolean check(List<Integer> list){
        String s = toString(list);
        if(!set.contains(s)){
            set.add(s);
            return true;
        }else{
            return false;
        }
    }
}