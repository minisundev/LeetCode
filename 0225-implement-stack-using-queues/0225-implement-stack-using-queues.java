class MyStack {
    // 1 :다 뽑아 1
    // 2 1 :2넣고 1넣어
    // 3 2 1: 3넣고 다 뽑았다가 2넣고 1넣어
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(q1.isEmpty()){
            //q2를 다 뽑았다가 q1에 넣기
            q1.offer(x);
            while(!q2.isEmpty()){
                q1.offer(q2.poll());
            }
            return;
        }
        if(q2.isEmpty()){
            //q1을 다 뽑았다가 q2에 넣기
            q2.offer(x);
            while(!q1.isEmpty()){
                q2.offer(q1.poll());
            }
        }
    }
    
    public int pop() {
        if(!q1.isEmpty()){
            return q1.poll();
        }
        if(!q2.isEmpty()){
            return q2.poll();
        }
        return 0;
    }
    
    public int top() {
        if(!q1.isEmpty()){
            return q1.peek();
        }
        if(!q2.isEmpty()){
            return q2.peek();
        }
        return 0;
    }
    
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */