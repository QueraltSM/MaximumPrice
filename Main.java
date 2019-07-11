import java.util.*;
import java.lang.*;
import java.io.File;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Main {

  static List<Integer> prices = new ArrayList<>();
  static BruteForce boxBruteForce = new BruteForce();
  static Tabulation boxTabulation = new Tabulation();
  static Memoization boxMemoization= new Memoization();
  static long start;

  public static void main(String[] args) {
    if (args.length < 1) System.out.println("Error: Invalid number of arguments");
    else
      if (Files.exists(Paths.get(args[0]))) {
      try {
          List<String> lines = Files.readAllLines(Paths.get(args[0]));
          for (String line : lines)
              for (String number : line.split(" ")) prices.add(Integer.parseInt(number));
          start(prices);
      } catch (IOException e) {}
   } else System.out.println("Error: File does not exist");
}

  public static void start(List<Integer> prices ) {
      //start = System.nanoTime();
      //System.out.println(boxBruteForce.getMaxCount(prices.size(),prices));
      //System.out.println("Brute Force - Execution time = " + (System.nanoTime() - start) + " nanoseconds");
      //start = System.nanoTime();
      System.out.println(boxTabulation.getMaxCount(prices.size(),prices));
      //System.out.println("Tabulation - Execution time = " + (System.nanoTime() - start) + " nanoseconds");
      //start = System.nanoTime();
      System.out.println(boxMemoization.getMaxCount(prices.size(),prices));
      //System.out.println("Memoization - Execution time = " +  (System.nanoTime() - start) + " nanoseconds");
  }
}
