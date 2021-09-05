class Solution {
    
    private static final char backspace = '#';
    
    private int getIndex(String s, int index) {
        int charsToSkip = 0;
        while (index >= 0) {
            if (s.charAt(index) == backspace) {
                charsToSkip++;
            } else if (charsToSkip > 0){
                charsToSkip--;
            } else {
                break;
            }
            index--;
        }
        return index;    
    }
    
    public boolean backspaceCompare(String s, String t) {
        int first = s.length() - 1;
        int second = t.length() - 1;
        while (first >= 0 || second >= 0) {
            first = getIndex(s, first);
            second = getIndex(t, second);
            if (first < 0 && second < 0) {
                return true;
            }  
            if (first < 0 || second < 0) {
                return false;
            }
            if (s.charAt(first) != t.charAt(second)) {
                return false;
            }
            first--;
            second--;
        }
        return true;
    }
}