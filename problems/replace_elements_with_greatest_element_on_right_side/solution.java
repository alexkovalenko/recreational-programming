class Solution {
    public int[] replaceElements(int[] arr) {
        int end = arr.length - 1;
        int max = - 1;
        while (end >= 0) {
            int tmp = arr[end];
            arr[end] = max;
            max = Math.max(max, tmp);
            end--;
        }
        return arr;
    }
}