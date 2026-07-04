class Solution {

    public void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int x = st.pop();

        sortStack(st);

        insert(st, x);
    }

    private void insert(Stack<Integer> st, int x) {

        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }

        int top = st.pop();

        insert(st, x);

        st.push(top);
    }
}