import java.util.*;
import java.lang.*;

public class Main {

  static List<Integer> prices = new ArrayList<>();
  static BruteForce boxBruteForce = new BruteForce();
  static Tabulation boxTabulation = new Tabulation();
  static Memoization boxMemoization= new Memoization();
  static long start;

  public static void main(String[] args){
    prices.add(2);
    prices.add(5);
    prices.add(5);
    prices.add(10);
    prices.add(1);
    prices.add(5);
    prices.add(30);
    prices.add(40);
    start = System.nanoTime();
    boxBruteForce.getMaxCount(prices.size(),prices);
    System.out.println("Brute Force - Execution time = " + (System.nanoTime() - start) + " nanoseconds");
    start = System.nanoTime();
    boxTabulation.getMaxCount(prices.size(),prices);
    System.out.println("Tabulation - Execution time = " + (System.nanoTime() - start) + " nanoseconds");
    start = System.nanoTime();
    boxMemoization.getMaxCount(prices.size(),prices);
    System.out.println("Memoization - Execution time = " +  (System.nanoTime() - start) + " nanoseconds");
  }
}
