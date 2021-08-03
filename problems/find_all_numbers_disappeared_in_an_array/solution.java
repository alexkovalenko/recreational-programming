class Solution {
    public List<Integer> findDisappearedNumbers(int[] n) {
        int i = 0;
        while (i < n.length) {
            int pos = n[i] - 1;
            if (n[pos] != n[i]) {
                n[pos] = n[pos] + n[i];
                n[i] = n[pos] - n[i];
                n[pos] = n[pos] - n[i];
            } else {
                i++;
            }
        }
        
        List<Integer> disappeared = new ArrayList<>();
        for (int j = 0; j < n.length; j++) {
            if (n[j] != j + 1) {
                disappeared.add(j + 1);
            }
        }
        return disappeared;
    }
}