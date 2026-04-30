class MyQueue {
    //1 2 3 4
    //4 3 2 1
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() { 
        if(!s1.isEmpty()){
           return s1.pop();
        }
        return 0;
    }
    
    public int peek() {
        if(!s1.isEmpty()){
            return s1.peek();
        }
        return 0;
    }
    
    public boolean empty() {
        if(s1.isEmpty()&&s2.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */