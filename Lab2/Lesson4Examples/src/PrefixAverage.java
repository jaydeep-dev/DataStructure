/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Demonstration of algorithms for computing the prefix averages of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class PrefixAverage {

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    for (int j=0; j < n; j++) {
      double total = 0;            // begin computing x[0] + ... + x[j]
      for (int i=0; i <= j; i++)
        total += x[i];
      a[j] = total / (j+1);        // record the average
    }
    return a;
  } // This function is getting around 2200ms to execute due to the inner for-loop that reset every time after iterating which the cause of increased time, yet the time it takes is relatively low even with 100,000 OR 100K elements

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
    for (int j=0; j < n; j++) {
      total += x[j];               // update prefix sum to include x[j]
      a[j] = total / (j+1);        // compute average based on current sum
    }
    return a;
  } // This function is gettings around 0-1ms to execute due to just one for loop and can handle about 100,000,000 OR 1M elements with less than 500ms

  public static void main(String[] args) {
    
    final int TRIALS = 10;
    final int SIZE = 100000000;
    double[] array = new double[SIZE];

    for (int i = 0; i < array.length; i++) {
      array[i] = i + 1;
    }
    // let's run version 1 (the quicker one) first
    System.out.println("Testing prefixAverage1...");
    double n = SIZE;
    for (int t=0; t < TRIALS; t++) {
      long startTime = System.currentTimeMillis();
      prefixAverage2(array);
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println("n: " + n + " took " + elapsed + " milliseconds");
      n *= 2;                                // double the problem size
    }

    // let's run version 2 (the slower one) first
    // System.out.println("Testing prefixAverage2...");
    // n = SIZE;
    // for (int t=0; t < TRIALS; t++) {
    //   long startTime = System.currentTimeMillis();
    //   prefixAverage1(array);
    //   long endTime = System.currentTimeMillis();
    //   long elapsed = endTime - startTime;
    //   System.out.println("n: " + n + " took " + elapsed + " milliseconds");
    //   n *= 2;                                // double the problem size
    // }
  }
}
