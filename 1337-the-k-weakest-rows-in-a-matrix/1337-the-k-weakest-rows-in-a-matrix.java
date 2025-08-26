class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>(
            (o1,o2)->{
                if(o1.soldier!=o2.soldier){
                    return o1.soldier-o2.soldier;
                }
                return o1.idx-o2.idx;
            }
        );
        for(int i=0; i<mat.length; i++){
            int sum = 0;
            for(int j=0; j<mat[0].length; j++){
                sum +=  mat[i][j];
            }
            pq.add(new Row(sum,i));
        }
        int [] answer = new int [k];

        for(int i=0; i<k; i++){
            answer[i] = pq.poll().idx;
        }

        return answer;
    }
}

class Row{
    public int soldier;
    public int idx;
    public Row(int s, int i){
        soldier = s;
        idx = i;
    }
}