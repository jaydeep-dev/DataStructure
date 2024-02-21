package MidtermCode.exercises;

/**
 * Exercise1
 */
public class Exercise1 {

    int callCount = 1;
    int max;

    // If you don't know the max in array
    public int findMax(int[] arr) {
        if (callCount >= arr.length) {
            return arr[callCount - 1];
        }
        //System.out.println("Comparing values: C:" + arr[callCount] + " & M:" + max);
        max = Math.max(arr[callCount], max);
        callCount++;

        return findMax(arr, max);
    }

    // If you know the potential max number
    public int findMax(int[] arr, int max) {
        if (callCount >= arr.length) {
            return max;
        }
        //System.out.println("Comparing values: C:" + arr[callCount] + " & M:" + max);
        max = Math.max(arr[callCount], max);
        callCount++;

        return findMax(arr, max);
    }
}