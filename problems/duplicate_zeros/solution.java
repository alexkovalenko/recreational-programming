class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (!queue.isEmpty()) {
                Integer prev = queue.poll();  
                arr[i] = prev;
                queue.add(cur);
            } 
            if (cur == 0) {
                queue.add(0);    
            }
        }
    }
}