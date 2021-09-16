class Solution {
    public int heightChecker(int[] h) {
        int[] s = Arrays.copyOf(h, h.length);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < h.length; i++) {
            if (s[i] != h[i])
                count++;
        }
        return count;
    }
}