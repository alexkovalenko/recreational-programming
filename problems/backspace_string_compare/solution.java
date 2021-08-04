class Solution {
    public boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
    }
    
    private String backspace(String s) {
        char[] b = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
          if (c == '#') {
                if (i > 0) {
                    b[--i] = 0;
                }
            } else {
                b[i++] = c;
            }
        }
        return new String(b).trim();
    }
}