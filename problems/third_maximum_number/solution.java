class Solution {
    public int thirdMax(int[] n) {
        int[] r = removeDuplicates(n);
        return r.length < 3 ? r[r.length - 1] : r[r.length - 3];
    }
    
    public int[] removeDuplicates(int[] n) {
        return Arrays.stream(n).distinct().sorted().toArray();
    }
}