class Solution {

    int[] parent;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        int[][] jobs = new int[n][2];

        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];

            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        parent = new int[maxDeadline + 1];

        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalProfit = 0;

        for (int[] job : jobs) {

            int slot = find(job[0]);

            if (slot > 0) {

                count++;
                totalProfit += job[1];

                parent[slot] = find(slot - 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);

        return ans;
    }
}
