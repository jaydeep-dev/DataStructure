package MidtermCode.exercises;

public class Exercise3 {

    int[] max = new int[10];
    int count = 0;

    public void max10(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i = 0; i < max.length; i++) {
            max[i] = arr[i];
        }
    }
    public void displayMax10() {
        System.out.println("Max 10 values in give array are:");
        for (int i = 0; i < max.length; i++) {
            System.out.println((i + 1) + " -> " + "["+max[i]+"]");
        }
    }

}
