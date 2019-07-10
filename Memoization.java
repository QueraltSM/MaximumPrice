import java.util.*;

public class Memoization {

  public int getMaxCount(int N, List<Integer> prices) {
      Map<Integer, Integer> cache = new HashMap<>();
      cache.put(0, prices.get(0));
      cache.put(1, Math.max(cache.get(0),prices.get(1)));
      for (int i = 2; i<prices.size(); i++) {
        calculateMaxCount(i,prices,cache);
      }
      return cache.get(cache.size()-1);
  }

  private int calculateMaxCount(int N, List<Integer> prices, Map<Integer, Integer> cache) {
    if (N==0) return cache.get(0);
    if (N==1) return cache.get(1);
    if (cache.get(N) != null) return cache.get(N);
    int result = Math.max(prices.get(N)+calculateMaxCount(N-2,prices,cache), calculateMaxCount(N-1,prices,cache));
    cache.put(N,result);
    return result;
  }
}
