class Solution {
    public void reverseString(char[] s) {
        
        Stack<Character> st = new Stack<>();
        for(char ch : s)
            st.push(ch);
        int idx = 0;
        while(!st.isEmpty()){
            s[idx] = st.pop();
            idx++;
        }


    }
}