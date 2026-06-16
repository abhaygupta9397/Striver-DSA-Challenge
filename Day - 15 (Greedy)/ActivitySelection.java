class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        int activity[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            activity[i][0] = start[i];
            activity[i][1] = finish[i];
        }
        
        Arrays.sort(activity , (a,b)->a[1]-b[1]);
        //sorted on the basis of the end time
        
        int count = 1;
        int lastTime = activity[0][1];
        
        for(int i = 1; i < n; i++){
            if(activity[i][0] > lastTime){
                count++;
                lastTime = activity[i][1];
            }
        }
        return count;
        
    }
}
