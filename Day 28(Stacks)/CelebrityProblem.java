class Solution {//elimination algorith
    public int celebrity(int mat[][]) {
        // code here
        int celeb = 0;
        int n = mat.length;
        for(int i = 1; i < n; i++){
            if(mat[celeb][i] == 1){
                celeb = i;//this is the potential here
            }
        }
        //lets check it out
        for(int i = 0; i < n; i++){
            if(i == celeb)continue;
            if(mat[celeb][i] == 1 || mat[i][celeb] == 0)
            return -1;
        }
        return celeb;
    }
}