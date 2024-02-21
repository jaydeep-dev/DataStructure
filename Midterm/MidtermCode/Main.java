package MidtermCode;

import MidtermCode.exercises.Exercise1;
import MidtermCode.exercises.Exercise2;
import MidtermCode.exercises.Exercise3;

public class Main {
    // Exercise 1
    public static void exercise1() {
        int[] myArr = { 1, 2, 3, 4, 5, 11, 7, 8, 9, 10 };
        Exercise1 exercise = new Exercise1();
        int max = myArr[0];
        //int result = exercise.findMax(myArr, max);
        int result = exercise.findMax(myArr);
        System.out.println(result + " is the maximum number is given array!");
    }

    public static void exercise2() {
        Exercise2 exercise = new Exercise2();
        exercise.reverseList();
    }

    public static void exercise3() {
        Exercise3 exercise = new Exercise3();
        int[] myArr = { 1, 2, 3, 4, 5, 11, 7,7,7,7, 7,8, 9, 10,12,13,14,15,66,4,433,5,3,22,4,55,6,7,7,88,9,9,999 };

        exercise.max10(myArr);
        exercise.displayMax10();
    }

    public static void main(String[] args) {
        System.out.println("Exercise 1:");
        exercise1();
        System.out.println();

        System.out.println("Exercise 2:");
        exercise2();
        System.out.println();

        System.out.println("Exercise 3:");
        exercise3();
        System.out.println();
    }
}
