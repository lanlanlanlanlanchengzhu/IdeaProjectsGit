package leetcode.no121;

/**
 * @see <href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/"></href>
 */
public class Solution {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > res) {
                    res = prices[j] - prices[i];
                }
            }
        }
        return res;
    }


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 维护目前最小价格及目前最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfitV1(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
