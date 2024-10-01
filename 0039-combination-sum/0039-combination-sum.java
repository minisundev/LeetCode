class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int [] arr;
    int goal;
    List<Integer> element = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //같은것이 있는 순열 문제 복습이네
        arr = candidates;
        goal = target;
        sum(0,0);
        return list;
    }

    void sum(int sum, int max){

        if(sum==goal){
            list.add(new ArrayList(element));
            return;
        }else if(sum>goal){
            return;
        }

        for(int i=max;i<arr.length;i++){
            element.add(arr[i]);
            sum(sum+arr[i],i);
            element.remove(element.size()-1);
        }
    }
}