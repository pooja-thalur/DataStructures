class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; 
        
        for (int[] query : queries) {
            int li = query[0], ri = query[1];
            diff[li]++;
            if (ri + 1 < n) {
                diff[ri + 1]--;
            }
        }

        int[] decrements = new int[n];
        decrements[0] = diff[0];
        if(nums[0]>decrements[0]){
            return false;
        }
        for (int i = 1; i < n; i++) {
            decrements[i] = decrements[i - 1] + diff[i];
            if(nums[i]>decrements[i]){
                return false;
            }
        }

        // Check if each nums can be reduced to 0
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] > decrements[i]) {
        //         return false; 
        //     }
        // }

        return true; 
    }
}