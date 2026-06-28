class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(m <= 1 || n == 1) return m;
        
        int low = 1;
        int high = m / n;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(Math.pow(mid , n) == m){
                return mid;
            }else if(Math.pow(mid,n) > m){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
