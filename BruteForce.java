import java.util.*;

public class BruteForce {

  private int globalSum=0;

  public int getMaxCount(int N, List<Integer> prices) {
      if (N==0) return 0;
      if (N==1) return prices.get(0);

      ListIterator<Integer> iterator = prices.listIterator();

      while(iterator.hasNext()){
        List<Integer> aux = new ArrayList<>();
        aux.addAll(prices);
        int sum = iterator.next();
        aux.remove(iterator.previous());
        aux.remove(iterator.next());
        if (iterator.hasNext()) aux.remove(iterator.next());
        imprimir(aux);
        splitArray(aux,sum);
      }
      /*for (int i = 0; i<prices.size()-1; i++) {
          List<Integer> aux = new ArrayList<>();
          aux.addAll(prices);
          int sum = prices.get(i);
          if (i>0) aux.remove(prices.get(i-1));
          aux.remove(prices.get(i));
          aux.remove(prices.get(i+1));
          splitArray(aux,sum);
      }*/
      return globalSum;
  }

  public void imprimir(List<Integer> aux) {
    for (int i : aux) {
      System.out.println(i);
    }
  }
  
  public void splitArray(List<Integer> aux, int sum){
      ListIterator<Integer> iterator = aux.listIterator();
      while(iterator.hasNext()){
        addCounter(aux, sum);
        aux.remove(iterator.nextIndex());
      }
  }

  public void addCounter(List<Integer> aux, int auxSum){
      ListIterator<Integer> iterator = aux.listIterator();
      while(iterator.hasNext()){
        auxSum += iterator.next();
        if (iterator.hasNext()) iterator.next();
      }
      if (auxSum > globalSum) globalSum = auxSum;
  }
}
