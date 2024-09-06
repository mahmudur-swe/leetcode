class CustomStack {

    int[] stack;
    int currentPos = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(currentPos == stack.length){
            return;
        }

        stack[currentPos++] = x;


    }
    
    public int pop() {
        if(currentPos>0){
            return stack[--currentPos]; 
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && i< stack.length && i<currentPos;i++){
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */