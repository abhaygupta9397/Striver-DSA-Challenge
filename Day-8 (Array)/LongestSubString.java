class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        while(true){
        while(j < n && !set.contains(s.charAt(j))){
            set.add(s.charAt(j));
            j++;
        }
        ans = Math.max(ans , j - i);
        if(j == n) break;
        while(i < n && s.charAt(i) != s.charAt(j)){
            set.remove(s.charAt(i));
            i++;
        }
        set.remove(s.charAt(i));i++;
        
       }
       return ans;
    }
}