

// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
Arrays.sort(stalls);
          int min = stalls[0];
          int max = min;
          for(int x : stalls){
              min = Math.min(min,x);
              max = Math.max(max,x);
          }
          int start = 0;
          int end = max - min;
          int ans = 0;
          while(start <= end){
              int mid = start + (end - start) / 2;
              if(isSafe(stalls,mid,k)){
                  ans = mid;
                  start = mid + 1;
              }
              else{
                  end = mid - 1;
              }
          }
          return ans;
    }
    public static boolean isSafe(int stalls[] , int dis ,  int cows){
        int prev = stalls[0];
        cows--;
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - prev < dis)continue;
            prev = stalls[i];
            cows--;
            if(cows==0)return true;
        }
        return false;}
}