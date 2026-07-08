class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        map.put('V' , 5);
        map.put('I' , 1);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);
        
        int n = s.length();
        int ans = map.get(s.charAt(n-1));
        for(int j = n - 2; j >= 0; j--){
            int curr =  map.get(s.charAt(j));
            if(map.get(s.charAt(j+1)) > curr){
                ans -= curr;
            }else{
                ans += curr;
            }
        }
        return ans;
    }
}