package Lab3.Exercise1;

public class Product {
    public static void main(String[] args) {
        int m = 5;
        int n = -3;
        int product = multiply(m, n);
        System.out.println("Product of " + m + " and " + n + " is: " + product);
    }

    public static int multiply(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (n == 1) {
            return m;
        }

        if (n < 0) {
            return -multiply(m, -n);
        }
        
        return m + multiply(m, n - 1);
    }
}
