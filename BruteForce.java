import java.util.*;

public class BruteForce {

  public int getMaxCount(int n, List<Integer> prices) {
    int result = 0;
    List<Integer> aux;
    for (List<Integer> permutation : new PermutationIterable<>(prices)) {
        aux = permutation;
        int auxResult = calculateMaxCount(aux);
        if (auxResult > result) result = auxResult;
    }
    return result;
  }

  public int calculateMaxCount(List<Integer> prices) {
    int prevOne = 0;
    int prevTwo = 0;
    int auxResult = 0;
    ListIterator<Integer> iterator = prices.listIterator();
    while (iterator.hasNext()) {
      if (iterator.nextIndex()==0) auxResult = iterator.next();
      else if (iterator.nextIndex()==1) {
        auxResult = Math.max(iterator.previous(), iterator.next());
        iterator.next();
      } else auxResult = Math.max(prevOne, (iterator.next()+prevTwo));
      prevTwo = prevOne;
      prevOne = auxResult;
    }
    return auxResult;
  }
}
