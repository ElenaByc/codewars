import java.util.Arrays;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(tribonacci(new double[]{1, 1, 1}, 10)));
        System.out.println(Arrays.toString(tribonacci(new double[]{0, 0, 1}, 10)));
        System.out.println(Arrays.toString(tribonacci(new double[]{0, 1, 1}, 10)));
    }

    public static double[] tribonacci(double[] s, int n) {
        if (n == 0) { //  then return an empty array
            return new double[]{};
        }
        double[] result = new double[n];
        System.arraycopy(s, 0, result, 0, 3);
        for (int i = 3; i < n; i++) {
            result[i] = result[i - 3] + result[i - 2] + result[i - 1];
        }

        return result;
    }

}
