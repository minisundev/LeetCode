class Solution {
    // PriorityQueue<Integer> left = new PriorityQueue<>(
    //         (o1, o2) -> o2 - o1);//큰게 위로
    // PriorityQueue<Integer> right = new PriorityQueue<>(
    //         (o1, o2) -> o1 - o2);//작은게 위로

    
    // ArrayDeque<Integer> left = new ArrayDeque<>();//큰게 뒤로
    // ArrayDeque<Integer> right = new ArrayDeque<>();//큰게 뒤로 ...

    TreeMap<Integer,Integer> left = new TreeMap<>();//큰게 뒤로
    TreeMap<Integer,Integer> right = new TreeMap<>();//큰게 뒤로 ...

    int leftSize = 0;
    int rightSize = 0;

    double [] answer;


    public double[] medianSlidingWindow(int[] nums, int k) {

        answer = new double[nums.length-k+1];
        
        for(int i=0; i<k; i++){
            add(nums[i]);
        }
        set(0);

        for(int i=k; i<nums.length; i++){
            add(nums[i]);
            remove(nums[i-k]);
            set(i-k+1);

            //System.out.println(i+": "+leftSize+":"+rightSize);
        }

        return answer;
    }

    void even(){
        if(Math.abs(leftSize-rightSize)<=1) return;

        if(leftSize>rightSize){
            Map.Entry<Integer,Integer> entry = left.pollLastEntry();
            if(entry.getValue()>1){
                right.put(entry.getKey(),right.getOrDefault(entry.getKey(),0)+1);
                rightSize++;
                left.put(entry.getKey(),entry.getValue()-1);
                leftSize--;
            }else{
                right.put(entry.getKey(),right.getOrDefault(entry.getKey(),0)+1);
                rightSize++;
                left.remove(entry.getKey());
                leftSize--;
            }
        }else if(leftSize<rightSize){
            Map.Entry<Integer,Integer> entry = right.pollFirstEntry();
            if(entry.getValue()>1){
                left.put(entry.getKey(),left.getOrDefault(entry.getKey(),0)+1);
                leftSize++;
                right.put(entry.getKey(),entry.getValue()-1);
                rightSize--;
            }else{
                left.put(entry.getKey(),left.getOrDefault(entry.getKey(),0)+1);
                leftSize++;
                right.remove(entry.getKey());
                rightSize--;
            }
        }
    }

    void add(int n){
        if(!left.isEmpty() && left.lastKey()>=n){
            left.put(n, left.getOrDefault(n,0)+1);
            leftSize++;
        }else if(!right.isEmpty() && right.firstKey()<=n){
            right.put(n, right.getOrDefault(n,0)+1);
            rightSize++;
        }else{
            left.put(n, 1);
            leftSize++;
        }    
        even();
    }

    void remove(int n){
        if(left.containsKey(n)){
            int count = left.get(n);
            count--;
            leftSize--; 
            if(count==0){ 
                left.remove(n);
            }else{
                left.put(n,count);
            }

        }else {
            int count = right.get(n);
            count--;
            rightSize--; 
            if(count==0){ 
                right.remove(n);
            }else{
                right.put(n,count);
            }
        }
        even();
    }

    void set(int index){
        if(leftSize==rightSize+1){
            answer[index] = left.lastKey();
        }else if(leftSize+1==rightSize){
            answer[index] = right.firstKey();
        }else if(leftSize==rightSize){
            answer[index] = ((double)left.lastKey() + (double)right.firstKey())/2;
        }
    }
}