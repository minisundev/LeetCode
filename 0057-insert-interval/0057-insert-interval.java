class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length==0){
            int [][] result = new int [1][2];
            result[0] = newInterval;
            return result;
        }

        List<int[]> list = new ArrayList<>();
        int [] overlap = new int[2];
        overlap[0] = newInterval[0];
        overlap[1] = newInterval[1];
        int i=0;

        for(; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(end<newInterval[0]){
                list.add(intervals[i]);
            }else{//end>=newInterval[0]
                overlap[0] = Math.min(newInterval[0],start);;
                //System.out.println("break at start "+start);
                break;
            }
        }

        for(; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start<=newInterval[1]){
                overlap[1] = Math.max(newInterval[1],end);
            }else{//start>newInterval[1]
                break;
            }
        }
        
        list.add(overlap);

        for(; i<intervals.length; i++){
            list.add(intervals[i]);
        }

        int [][] answer = new int [list.size()][2];
        int index = 0;
        for(int [] arr : list){
            answer[index++] = arr;
        }
        return answer;
    }
}