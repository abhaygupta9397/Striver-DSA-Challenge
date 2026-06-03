
class Solution { //two pointers simulation Gaurav interview
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]); //how this works ?
        int n = intervals.length;
        List<List<Integer>> li = new LinkedList<>();
        int i = 0;
        int j = 1;
        while(i < n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(j < n && intervals[j][0] <= end ){
                end = Math.max(end,intervals[j][1]);
                j++;
            }
            i = j; //clever move by Gaurav
            List l = new LinkedList<>();
            l.add(start);
            l.add(end);
            li.add(l);
        }
        int size = li.size();
        int arr[][] = new int[size][2];
        int p = 0;
        for(List<Integer> l : li){
            arr[p][0] = l.get(0); //start
            arr[p][1] = l.get(1); //end
            p++;
        }
        return arr;
    }
}