class Solution {//Boyer moore algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int elem = Integer.MIN_VALUE;
        
        //first lecture
        for(int x : nums){
            if(count == 0){
                elem = x;
                count = 1;
            }else if(elem == x){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for(int x : nums){
            if(x == elem){
                count++;
            }
        }
        return (count > n/2) ? elem : -1;
    }
}
