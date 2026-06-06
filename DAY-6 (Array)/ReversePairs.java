class Solution1 {//works with the Sorting Algorithm O(n logn )time asked in Hasedin By Delloite
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length - 1);
    }
    private int mergeSort(int a[] , int l , int r){
        if(l >= r) return 0;

        int m = l + (r - l) / 2;

        int cnt = 0;

        //get the left half pairs
        cnt += mergeSort(a , l ,m);
        //get the right half pairs
        cnt += mergeSort(a , m+1 , r);

        //now we can count the cross pairs
        int j = m+1;
        for(int i = l; i <= m; i++){
            while(j <= r && a[i] > 2L *a[j])
            j++;
            
            //two pointers count here
            cnt += j - (m+1);
        }
        merge(a,l,m,r);
        return cnt;
    }

    public void merge(int a[] , int l , int m , int r){
        int temp[] = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;

        while(i <= m && j <= r){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }

        while(i <= m)temp[k++] = a[i++];
        while(j <= r)temp[k++] = a[j++];

        for(int p = 0; p < temp.length; p++)
        a[l+p]  = temp[p];
    }
}
class Solution {//BIT data structure

    public int reversePairs(int[] nums) {

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int[] bit = new int[nums.length + 1];

        int ans = 0;

        for (int x : nums) {

            int idx = getIndex(sorted, 2L * x + 1);

            int totalSeen = query(bit, nums.length);

            int lessOrEqual = query(bit, idx - 1);

            ans += totalSeen - lessOrEqual;

            update(bit, getIndex(sorted, x));
        }

        return ans;
    }

    private void update(int[] bit, int idx) {

        while (idx < bit.length) {
            bit[idx]++;
            idx += idx & -idx;
        }
    }

    private int query(int[] bit, int idx) {

        int sum = 0;

        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }

        return sum;
    }

    private int getIndex(int[] arr, long val) {

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }
}
