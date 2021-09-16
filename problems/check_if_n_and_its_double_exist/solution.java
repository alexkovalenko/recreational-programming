class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (memo.containsKey(arr[i] * 2) || (arr[i] % 2 == 0 && memo.containsKey(arr[i] / 2))) {
                return true;
            }
            memo.put(arr[i], i);
        }
        return false;
    }
}