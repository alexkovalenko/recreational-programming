class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1, direction = 0;
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i < right + 1; i++) 
                    res.add(matrix[top][i]);
                top++;
                direction = 1;
            } else if (direction == 1) {
                for (int i = top; i < bottom + 1; i++) 
                    res.add(matrix[i][right]);
                right--;
                direction = 2;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) 
                    res.add(matrix[bottom][i]);
                bottom--;
                direction = 3;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) 
                    res.add(matrix[i][left]);
                left++;
                direction = 0;
            }
        }
        return res;
    }
}