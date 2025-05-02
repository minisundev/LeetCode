class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(
            (o1,o2)->o2.num-o1.num
        );

        int [] answer = new int[nums.length-k+1];

        for(int i=0; i<k; i++){
            pq.add(new Element(nums[i],i));
        }

        for(int i=k-1;i<nums.length;i++){
            pq.add(new Element(nums[i],i));
            while(!pq.isEmpty()&&pq.peek().index<=i-k){
                //System.out.println("index"+pq.peek().index+"out at "+i);
                pq.poll();
            }
            if(!pq.isEmpty()){
            answer[i-k+1] = pq.peek().num;
            }
        }

        return answer;
    }

}

class Element{
    public int num;
    public int index;
    public Element(int n, int i){
        num = n;
        index = i;
    }
}