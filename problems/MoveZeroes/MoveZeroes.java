

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int[] sorted = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                sorted[index++] = num;
            }
        }
        System.arraycopy(sorted, 0, nums, 0, nums.length);
    }
}
