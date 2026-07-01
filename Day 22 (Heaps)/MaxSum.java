import java.util.*;

class Solution {

    static class Node {
        int sum;
        int i;
        int j;

        Node(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {

        int n = a.length;

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.sum - x.sum);

        HashSet<String> visited = new HashSet<>();

        pq.offer(new Node(a[n - 1] + b[n - 1], n - 1, n - 1));
        visited.add((n - 1) + "#" + (n - 1));

        ArrayList<Integer> ans = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {

            Node curr = pq.poll();
            ans.add(curr.sum);

            int i = curr.i;
            int j = curr.j;

            if (i - 1 >= 0) {
                String key = (i - 1) + "#" + j;
                if (!visited.contains(key)) {
                    pq.offer(new Node(a[i - 1] + b[j], i - 1, j));
                    visited.add(key);
                }
            }

            if (j - 1 >= 0) {
                String key = i + "#" + (j - 1);
                if (!visited.contains(key)) {
                    pq.offer(new Node(a[i] + b[j - 1], i, j - 1));
                    visited.add(key);
                }
            }
        }

        return ans;
    }
}
