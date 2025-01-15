class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> list = new ArrayList<>();
        //merge를 시켜보자...나 이거 풀었던 거 같은데 아닌가? 왜 체크가 안 되어 있지
        //정렬부터 하셔야죠...

        for(int [] i : intervals){
            int start = i[0];
            int end = i[1];
            list.add(new int[]{start,end});
        }

        Collections.sort(list, (o1,o2)->{
            if(o1[0]!=o2[0]){
                return o2[0]-o1[0];
            }
            return o2[1]-o1[1];
        });
        
        for(int i=list.size()-1;i>0;i--){
            int [] i2 = list.get(i-1);
            int [] i1 = list.get(i);
            //당연한 것 : i1[0]<=i2[0]
            if(i1[0]<=i2[0]&&i1[1]>=i2[1]){
                list.remove(i-1);
            }else if(i2[0]<=i1[1]){
                i1[1] = Math.max(i2[1],i1[1]);
                list.remove(i-1);
            }else if(i2[1]<=i1[1]){
                list.remove(i-1);
            }
        }
        
        int [][] answer = new int [list.size()][2];
        int index = 0;
        for(int [] i : list){
            answer[index++] = i;
        }
        return answer;
    }
}