class Solution {//O(3*N) time
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        //find the pivot
        int pivot = -1;
        for(int i = n - 2;i >= 0; i--){
            if(nums[i] >= nums[i+1]){
                continue;
            }else{
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            swap(0,n-1,nums);
        }
        else{
            //find the just greater
            int just_greater = pivot;
            for(int i = pivot + 1; i < n; i++){
                if(nums[i] <= nums[pivot])break;
                just_greater = i;
            }
            int temp = nums[pivot];
            nums[pivot] = nums[just_greater];
            nums[just_greater] = temp;

            swap(pivot+1 , n - 1 , nums);
        }


    }
    public void swap(int i , int j , int nums[]){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}