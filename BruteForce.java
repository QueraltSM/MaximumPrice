import java.util.*;

public class BruteForce {

  private int globalSum=0;

  public int getMaxCount(int N, List<Integer> prices) {
      if (N==0) return 0;
      if (N==1) return prices.get(0);

      for (int i = 0; i<prices.size()-1; i++) {
          List<Integer> aux = new ArrayList<>();
          aux.addAll(prices);
          int sum = prices.get(i);
          if (i>0) aux.remove(prices.get(i-1));
          aux.remove(prices.get(i));
          aux.remove(prices.get(i+1));
          splitArray(aux,sum);
      }
      return globalSum;
  }

  public void splitArray(List<Integer> aux, int sum){
      for (int i = 0; i<aux.size(); i++) {
        addCounter(aux, sum);
        aux.remove(i);
      }
  }

  public void addCounter(List<Integer> aux, int auxSum){
      for (int i = 0; i<aux.size(); i+=2) {
        auxSum += aux.get(i);
      }
      if (auxSum > globalSum) globalSum = auxSum;
  }
}
