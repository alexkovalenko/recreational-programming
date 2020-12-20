class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> numsWithDuplicates = new HashSet();
        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    numsWithDuplicates.add(nums[i]);
                    break;
                }
            }
        }
        System.out.println(numsWithDuplicates);
        for(int i=0; i < nums.length; i++) {
            if(!numsWithDuplicates.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
    
}