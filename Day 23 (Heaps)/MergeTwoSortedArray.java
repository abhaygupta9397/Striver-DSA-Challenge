class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        
        int i = 0;
        for(int row[] : mat){
            pq.add(new int[] {row[0] , i++ , 0} );
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int val = arr[0];
            int row = arr[1];
            int col = arr[2];
            
            ans.add(val);
            
            if(col + 1 < mat[row].length){
                pq.offer(new int[] {mat[row][col+1] , row , col+1});
            }
        }
        return ans;
        
    }
}
