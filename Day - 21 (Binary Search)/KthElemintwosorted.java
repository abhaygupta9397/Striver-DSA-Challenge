class Solution {
    public int kthElement(int a[], int b[], int k) {

        // Always binary search on the smaller array
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int n = a.length;
        int m = b.length;

        // Valid range for cut1
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            // Left and Right values of partition
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : a[cut1];

            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : b[cut2];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            // Took too many elements from a
            else if (l1 > r2) {
                high = cut1 - 1;
            }

            // Took too few elements from a
            else {
                low = cut1 + 1;
            }
        }

        return -1;
    }
}