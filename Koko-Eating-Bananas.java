class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end = 0;

       
        for (int pile : piles) {
            if (pile > end) {
                end = pile;
            }
        }

        int start = 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int hours = 0;  // Keep track of total hours required

            // Calculate hours inline instead of using a separate function
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // division
                if (hours > h) break;  // Early exit to optimize time
            }

            if (hours <= h) {
                end = mid; 
            } else {
                start = mid + 1;  
            }
        }
        return start; 
    }
}