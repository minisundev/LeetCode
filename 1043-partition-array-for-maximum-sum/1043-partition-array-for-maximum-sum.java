class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int [] dp = new int [arr.length+1];
        List<Node> list = new ArrayList<Node>();
        
        for(int i=0;i<dp.length;i++){
            if(i<arr.length){
                list.add(new Node(i,arr[i]));
            }

            Node n;
            for(int j=list.size()-1; j>=0; j--){
                n= list.get(j);
                if(n.index<i-k){
                    list.remove(j);
                }
            }

            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    dp[i] = Math.max(dp[i],dp[i-j]+j*findMax(i-j,i-1,list));
                }
            }
        }
        
        return dp[dp.length-1];

    }

    int findMax(int start, int end, int [] arr){
        int max=0;
        for(int i = start; i<=end; i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }

    int findMax(int start, int end, List<Node> list){
        int max = 0;
        for(int i=list.size()-1; i>=0; i--){
            Node n = list.get(i);
            if(n.index>=start && n.index<=end){
                max=Math.max(max,n.value);
            }
        }
        return max;
    }
}
class Node{
    public int index;
    public int value;
    public Node (
        int i, int v
    ){
        index = i;
        value = v;
    }
}