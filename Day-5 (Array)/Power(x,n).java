class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        if(n < 0){
            return 1 / fun(x,-1 * (long)n);
        }else{
            return fun(x,(long)n);
        }
    }
    public double fun(double x , long n){
        if(n == 1) return x;
        if(n < 1) return 1;

        double cal = fun(x,n/2);
        if(n % 2 == 0){
            return cal * cal;
        }else {
            return x * cal * cal;
        }
    }
}