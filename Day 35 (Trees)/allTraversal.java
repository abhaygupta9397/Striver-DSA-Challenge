
class Pair {
    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

class Solution {

    public List<List<Integer>> allTraversal(TreeNode root) {

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null)
            return Arrays.asList(pre, in, post);

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {

            Pair curr = st.pop();

            if (curr.state == 1) {

                // Preorder
                pre.add(curr.node.val);

                curr.state = 2;
                st.push(curr);

                if (curr.node.left != null)
                    st.push(new Pair(curr.node.left, 1));

            } else if (curr.state == 2) {

                // Inorder
                in.add(curr.node.val);

                curr.state = 3;
                st.push(curr);

                if (curr.node.right != null)
                    st.push(new Pair(curr.node.right, 1));

            } else {

                // Postorder
                post.add(curr.node.val);
            }
        }

        return Arrays.asList(pre, in, post);
    }
}