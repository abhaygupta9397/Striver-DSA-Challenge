class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        //transpose of matrix
        for(int i = 0; i < row; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse the each row
        for(int r = 0; r < row; r++){
            reverse(matrix[r]);
        }
      
    }
    public void reverse(int arr[]){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i++] - arr[j--];
        }
    }
}