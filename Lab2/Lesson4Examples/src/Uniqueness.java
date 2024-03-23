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

import java.util.Arrays;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  public static void main(String[] args) {
    final int SIZE = 50000;
    final int TRIALS = 10;
    int[] array = new int[SIZE];

    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }

    System.out.println("Testing unique1...");
    double n = SIZE;
    for (int t=0; t < TRIALS; t++) {
      long startTime = System.currentTimeMillis();
      unique1(array);
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println("n: " + n + " took " + elapsed + " milliseconds");
      n *= 2;                                // double the problem size
    }

    System.out.println("Testing unique2...");
    n = SIZE;
    for (int t=0; t < TRIALS; t++) {
      long startTime = System.currentTimeMillis();
      unique2(array);
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println("n: " + n + " took " + elapsed + " milliseconds");
      n *= 2;                                // double the problem size
    }
  }
}
