class StockSpanner {

    Stack<int[]> st;
    int cnt = 0;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int span;
        if(st.isEmpty()){
            span = cnt+1;
        }else{
            span = cnt - st.peek()[1];
        }

        st.push(new int[]{price,cnt++});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */