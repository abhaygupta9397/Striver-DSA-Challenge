class Solution1 {//Idea 1 - O(m*n)time & O(m+n)space
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean stripR [] = new boolean[n];
        boolean stripC [] = new boolean[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    stripR[i] = true;
                    stripC[j] = true;
                }
            }
        }

        for(int r = 0; r < n; r++){
            if(stripR[r]){
                //fill this row with zero
                for(int j = 0; j < m; j++){
                    matrix[r][j] = 0;
                }
            }
        }

        for(int c = 0; c < m; c++){
            if(stripC[c]){
                for(int i = 0; i < n; i++){
                    matrix[i][c] = 0;
                }
            }
        }

    }
}
class Solution {//Idea 2 O(m*n)time & O(1)space
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean RowZero = false;
        boolean ColZero = false;

        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                ColZero = true;
            }
        }

        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                RowZero = true;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //now flood with zero
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++)
                matrix[i][j] = 0;
            }
        }

        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < m ; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        //now sweep zero on row and col 
        if(ColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if(RowZero){
            for(int j = 0; j < n ;j++){
                matrix[0][j] = 0;
            }
        }
        
    }
}