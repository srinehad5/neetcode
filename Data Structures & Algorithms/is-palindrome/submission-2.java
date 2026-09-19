class Solution {
    public boolean isPalindrome(String s) {
        
        int n = s.length();
        int i = 0, j = n-1;
        while(i < j){
            while(i < j && i < n && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(j > i && j >= 0 && !Character.isLetterOrDigit(s.charAt(j)))
                j--;

            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
