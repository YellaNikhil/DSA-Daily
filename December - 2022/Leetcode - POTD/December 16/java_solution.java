class MyQueue {
    public Stack<Integer> st1, st2;
    public MyQueue() {
        this.st1 = new Stack<Integer>();
        this.st2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.st1.push(x);
    }
    
    public int pop() {
        if(this.st2.isEmpty()){
            while(!this.st1.isEmpty()){
                this.st2.push(this.st1.pop());
            }
        }
        return this.st2.isEmpty()==false ? this.st2.pop() : -1;
    }
    
    public int peek() {
        if(this.st2.isEmpty()){
            while(!this.st1.isEmpty()){
                this.st2.push(this.st1.pop());
            }
        }
        return this.st2.isEmpty()==false ? this.st2.peek() : -1;
    }
    
    public boolean empty() {
        return this.st1.isEmpty() && this.st2.isEmpty();
    }
}