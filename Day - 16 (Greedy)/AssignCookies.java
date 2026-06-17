class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int lg = g.length;
        int ls = s.length;

        int i = 0;
        int j = 0;
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i < lg && j < ls){
            //favroable case
            if(g[i] <= s[j]){
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
}