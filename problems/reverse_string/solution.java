class Solution {
    public void reverseString(char[] s) {
        print(s, 0);
    }
    
    private void print(char[] s, int index) {
        if(s == null || index >= s.length / 2) {
            return;
        }   
        char c = s[index];
        s[index] = s[s.length - index - 1];
        s[s.length - index - 1] = c;
        print(s, index + 1);
    }
}