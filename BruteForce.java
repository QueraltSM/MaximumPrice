import java.util.*;

public class BruteForce {

  public int getMaxCount(int n, List<Integer> prices) {
    int prevOne = 0;
    int prevTwo = 0;
    int result = 0;

    ListIterator<Integer> iterator = prices.listIterator();
    while (iterator.hasNext()) {
      if (iterator.nextIndex()==0) result = iterator.next();
      else if (iterator.nextIndex()==1) {
        iterator.next();
        result = Math.max(iterator.previous(), iterator.next());
      } else result = Math.max(prevOne, iterator.next()+prevTwo);
      prevTwo = prevOne;
      prevOne = result;
    }
    return result;
  }
}
