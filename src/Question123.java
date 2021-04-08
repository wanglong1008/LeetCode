public class Question123 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < 3; i++) {
            dp[0][i][0] =0;
            dp[0][i][1]=-prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j][0] = dp[i - 1][j][0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }
        return Math.max(dp[prices.length-1][0][0],Math.max(dp[prices.length-1][1][0],dp[prices.length-1][2][0]));
    }
}
