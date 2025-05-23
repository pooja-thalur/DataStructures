class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[][] memo = new long[n+1][2];

        for(long[] row: memo){
            Arrays.fill(row, -1);
        }

        return findMaxSum(0, 1, nums, k, memo);
    }

    long findMaxSum(int idx, int isEven, int[] nums, int k, long[][] memo){
            if(idx==nums.length){
                return (isEven==1)? 0: Integer.MIN_VALUE;
            }

            if(memo[idx][isEven]!=-1){
                return memo[idx][isEven];
            }

            long noxorval = nums[idx] + findMaxSum(idx+1, isEven, nums, k, memo);
            long xorval = (nums[idx]^k) + findMaxSum(idx+1, isEven^1, nums, k, memo);

            return memo[idx][isEven] = Math.max(noxorval, xorval);
        }
}