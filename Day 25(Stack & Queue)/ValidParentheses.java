class Solution {
    public boolean isValid(String s) {
        HashMap<Character , Character> map = new HashMap<>();
        map.put( '(' , ')' );
        map.put( '[' , ']' );
        map.put( '{' , '}' );

        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '[' || ch == '{' || ch == '('){
                stk.push(ch);
            }else{
                if(stk.isEmpty())return false;

                if(map.get(stk.pop()) != ch){
                    return false;
                }
            }
        }
        return stk.isEmpty() ? true : false;
    }
}