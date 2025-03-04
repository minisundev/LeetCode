class Solution {
    public int candy(int[] ratings) {
        int [] candy = new int [ratings.length];
        int candies = 0;
        
        //rating이 적은 순서대로 넣어놨다가..그리디로 풀면 될 거 같기도 하고 ㅜ
        PriorityQueue<Child> pq = new PriorityQueue<>(
            (o1,o2)->{
                return o1.rating - o2.rating;
            }
        );

        for(int i=0; i<ratings.length; i++){
            int rating = ratings[i];
            pq.add(new Child(i,rating));
        }

        while(!pq.isEmpty()){
            Child child = pq.poll();
            //  왼쪽과 비교~~~
            //  왼작 인 경우
            int min = 1;
            if(child.index-1>=0 && ratings[child.index-1]<ratings[child.index]){//왼쪽이 나보다 더 작은 경우
                min = candy[child.index-1]+1;
            }
            //오작 인 경우
            if(child.index+1<ratings.length && ratings[child.index]>ratings[child.index+1]){//오른쪽이 나보다 더 작은 경우
                min = Math.max(min,candy[child.index+1]+1);
            }
            candy[child.index]=min;
            candies += min;
        }

        return candies;
    }
}

class Child{
    public int index;
    public int rating;
    public Child(int i, int r){
        index = i;
        rating = r;
    }
}