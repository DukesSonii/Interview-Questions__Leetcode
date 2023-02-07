class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int i = 0, j = 0;
        while (i < n && j < n) {
            while(j < n - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        return i;
    }
}