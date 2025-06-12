class Solution(object):
    def maxProfit(self, prices):
        \\\
        :type prices: List[int]
        :rtype: int
        \\\
        n = len(prices)
        maxVal = [0] * n
        
        for i in range (n-2, -1, -1):
            maxVal[i] = max(maxVal[i+1], prices[i+1])
        print(maxVal)
        ans = 0
        for i in range(0, n):
            #cal the max diff
            ans = max(maxVal[i]-prices[i], ans)
        
        return ans
