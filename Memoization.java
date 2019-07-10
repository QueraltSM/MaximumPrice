import java.util.*;

public class Memoization {

  private Map<Integer, Integer> cache;

  public int getMaxCount(int N, List<Integer> prices) {

      if (cache == null) {
        cache = new HashMap<>();
        cache.put(0, prices.get(0));
        cache.put(1, Math.max(cache.get(0),prices.get(1)));
      }

      if (N==0) return cache.get(0);
      if (N==1) return cache.get(1);

      if (cache.get(N) != null) return cache.get(N);

      for (int i = 2; i<prices.size(); i++)
        cache.put(i,Math.max(prices.get(i)+getMaxCount(i-2,prices), getMaxCount(i-1,prices)));

      return cache.get(cache.size()-1);
  }
}
