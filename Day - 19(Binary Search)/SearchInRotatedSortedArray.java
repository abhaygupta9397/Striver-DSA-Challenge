class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        // pivot point
        int s = 0, e = nums.length - 2;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid + 1] < nums[mid]) {
                break;
            }

            else if (nums[mid] < nums[0]) // 2nd half
            {
                e = mid - 1;
            } else if (nums[mid] > nums[nums.length - 1])// 1st half
            {
                s = mid + 1;
            }
            else {
                mid = -1;
                break ;
            }
        }

         //System.out.println(mid);
       // search space
       if (mid == -1)
       {
            s = 0;
            e = nums.length - 1;
       }
        else if (target < nums[0]) {
            s = mid + 1;
            e = nums.length - 1;
        } else if (target > nums[nums.length - 1]) {
            s = 0;
            e = mid;
        } 

        // mid = s + (e - s) / 2;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target)
                return mid;

            else if (nums[mid] > target) {
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            }
        }

        return -1;

    }
}
