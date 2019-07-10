import java.util.*;

public class BruteForce {
  
  public int getMaxCount(int n, List<Integer> prices) {
    ListIterator<Integer> iterator = prices.listIterator();
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
    return actual;
  }
}
