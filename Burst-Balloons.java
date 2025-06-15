class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int[] newNums = new int[n];
        int[][] memo = new int[n][n];
        newNums[0] = 1;
        newNums[n-1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n-2);
        
        return dp(newNums, memo, 1, n-2);
    }

    int dp(int[] nums, int[][] memo, int left, int right){
        if(right-left < 0) {
            return 0;
        }

        if(memo[left][right]>0){
            return memo[left][right];
        }

        int res = 0;
        for(int i = left; i<=right; i++){
            int gain = nums[left-1] * nums[i] * nums[right+1];

            int remaining = dp(nums, memo, left, i-1) + dp(nums, memo, i+1, right);

            res = Math.max(res, gain+remaining);
        }

        memo[left][right] = res;
        return res;
    }
}