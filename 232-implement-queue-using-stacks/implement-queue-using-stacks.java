class MyQueue {
    int r, f, n;
    int[] Q;

    public MyQueue() {
        this(10);
    }

    public MyQueue(int size) {
        this.r = -1;
        this.f = -1;
        this.n = size;
        Q = new int[size];
    }
    
 
    public void push(int x) {
        if (r >= n - 1) {
 
            return;
        }
        if (f == -1) {
          
            f = 0;
        }
        r++;
        Q[r] = x;
    }
 
    public int pop() {
        if (f == -1) {
 
            return -1;
        }
        int y = Q[f];
        if (f == r) {

            f = r = -1;
        } else {
            f++;
        }
        return y;
    }
    

    public int peek() {
        if (f == -1) {
    
            return -1;
        }
        return Q[f];
    }
    
    public boolean empty() {
        return f == -1;
    }
}