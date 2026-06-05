class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = searchRow(matrix,target,row,col);
        return binarySearch(matrix,target,r);
    }
    public boolean binarySearch(int matrix[][] , int target , int r){
        if(r == -1) return false;

        int low = 0;
        int high = matrix[0].length-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[r][mid] < target){
                low = mid + 1;
            }else if(matrix[r][mid] > target){
                high = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
    public int searchRow(int matrix[][] , int target , int row , int col){
        int low = 0;
        int high = row - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][col-1] < target){
                low = mid + 1;
                
            }else if(matrix[mid][0] > target){
                high = mid - 1;
            } else{ //if(matrix[mid][0] <= target && matrix[mid][col-1] >= target){
                return mid;
            }
        }
        return -1;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            int x = mid / n;
            int y = mid % n;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}
