class Solution {
    public int maxSubArray(int[] nums) {
        int st=nums[0], end=nums[0];
        for (int i=1;i<nums.length;++i){
            end= Math.max(end+nums[i],nums[i]);
            st=Math.max(st, end);	
        }
        return st;
        
    }
}