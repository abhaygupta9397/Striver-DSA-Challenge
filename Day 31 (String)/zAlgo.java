

// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
         ArrayList<Integer> ans = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        
        // Step 1: Build LPS array for the pattern
        int[] lps = buildLPS(pat);

        // Step 2: Search for pattern in the text
        int i = 0, j = 0; // i for txt, j for pat
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                // Pattern found, add starting index (1-based index)
                ans.add(i - j );
                j = lps[j - 1]; // Move to the last known prefix
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }

    // Helper function to build LPS array
    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
