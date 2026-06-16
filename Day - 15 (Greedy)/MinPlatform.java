class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n = arr.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0 , j = 0;
        int p = 0;
        int ans = 0;
        
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                p++;
                i++;
            }else{
                p--;
                j++;
            }
            ans = Math.max(ans , p);
        }
        return ans;
    }
}
