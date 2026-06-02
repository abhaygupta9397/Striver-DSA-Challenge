class Solution {//Dutch National Flag Algorithm
//from the flag of the Netherland 
//0-low-1 -> 0
//low to mid-1 -> 1
//mid to high
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(mid , low , nums);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(mid , high , nums);
                high--;
                //becuse the mid is unexamined so far
            }
        }
    }
    public void swap(int i , int j , int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}