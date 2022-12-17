class MyQueue {
public:
    stack<int> first, second;
    int last;
    MyQueue() {
        last = -1;
    }
    
    void push(int x) {
        first.push(x);
    }
    
    int pop() {
        if(first.empty() && second.empty()){
            return -1;
        }
        if(second.empty()){
            while(!first.empty()){
                second.push(first.top());
                first.pop();
            }
        }
        int x = second.top();
        second.pop();
        return x;
    }
    
    int peek() {
        if(second.empty()){
            while(!first.empty()){
                second.push(first.top());
                first.pop();
            }
        }
        return second.top();
    }
    
    bool empty() {
        return first.empty() && second.empty();
    }
};