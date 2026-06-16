class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;

        double[][] items = new double[n][3];

        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
            items[i][2] = (double) val[i] / wt[i]; // value/weight ratio
        }

        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

        double profit = 0.0;

        for (int i = 0; i < n && capacity > 0; i++) {

            int value = (int) items[i][0];
            int weight = (int) items[i][1];

            if (weight <= capacity) {
                profit += value;
                capacity -= weight;
            } else {
                profit += items[i][2] * capacity;
                break;
            }
        }

        return profit;
    }
}