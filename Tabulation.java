import java.util.*;

public class Tabulation {

  public int getMaxCount(int N, List<Integer> prices) {
      if (N==0) return 0;
      if (N==1) return prices.get(0);

      int[] dp = new int[prices.size()];
      dp[0] = prices.get(0);
      dp[1] = Math.max(dp[0],prices.get(1));

      for (int i = 2; i<prices.size(); i++)
        dp[i] = Math.max(prices.get(i)+dp[i-2],dp[i-1]);

      return dp[dp.length-1];
  }
}
