import java.util.*;

public class BruteForce {

  public int getMaxCount(int n, List<Integer> prices) {
    int res = prices.get(0);
    for (int i = 2; i<prices.size(); i++) {
      res = Math.max(res,Math.max(prices.get(i)+prices.get(i-2),prices.get(i-1)));
    }
    return res;

    /*ListIterator<Integer> iterator = prices.listIterator();
    int actual = iterator.next();
    int before = 0;
    int result;

    while (iterator.hasNext()) {
      if (before>actual) result = before;
      else result = actual;
      actual = before + iterator.next();
      before = result;
    }

    if (before>actual) return before;
    return actual;*/
  }
}
