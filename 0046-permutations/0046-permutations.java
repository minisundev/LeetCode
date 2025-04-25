class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int [] arr;
    boolean [] visit;

    public List<List<Integer>> permute(int[] nums) {
        arr = nums;
        visit = new boolean[arr.length];
        dfs(new ArrayList<>());
        return answer;
    }

    void dfs(List<Integer> list){
        if(list.size()==arr.length){
            answer.add(list);
            return;
        }

        for(int i=0; i<visit.length; i++){
            if(!visit[i]){
                visit[i]=true;
                List<Integer> copy = new ArrayList<>(list);
                copy.add(arr[i]);
                dfs(copy);
                visit[i]=false;
            }
        }
    }
}