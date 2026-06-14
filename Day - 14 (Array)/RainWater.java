class Solution {//two pointers idea
    public int trap(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;

        int h1 = 0;
        int h2 = 0;

        int water = 0;
        for(int k = 0; k < n; k++){
            h1 = Math.max(h1,height[i]);
            h2 = Math.max(h2,height[j]);

            if(h1 < h2){
                water += h1 - height[i];
                i++;
            }else{
                water += h2 - height[j];
                j--;
            }
        }
        return water;
    }
}
