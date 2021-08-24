class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            if (table[i]) {
                for (String word : wordDict) {
                    if (s.substring(i).startsWith(word)) {
                        table[i + word.length()] = true;
                    }
                }
            }
        }
        return table[s.length()];
    }
}