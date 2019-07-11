import java.util.*;

public class Memoization {

  public int getMaxCount(int N, List<Integer> prices) {
      Map<Integer, Integer> cache = new HashMap<>();
      cache.put(0, prices.get(0));
      cache.put(1, Math.max(cache.get(0),prices.get(1)));
      return calculateMaxCount(N-1,prices,cache);
  }

  private int calculateMaxCount(int N, List<Integer> prices, Map<Integer, Integer> cache) {
    if (cache.get(N) != null) return cache.get(N);
    cache.put(N,Math.max(prices.get(N)+calculateMaxCount(N-2,prices,cache), calculateMaxCount(N-1,prices,cache)));
    return cache.get(N);
  }
}
