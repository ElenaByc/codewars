public class DigPow {
    public static void main(String[] args) {
        System.out.println(digPow(89, 1));      // 1
        System.out.println(digPow(92, 1));      // -1
        System.out.println(digPow(695, 2));     // 2
        System.out.println(digPow(46288, 3));   // 51

    }

    public static long digPow(int n, int p) {
        long sum = 0;
        int len = Integer.toString(n).length();
        int pow = p + len - 1;
        int num = n;
        int digit;

        while (num > 0) {
            digit = num % 10;
            sum += Math.pow(digit, pow);
            num /= 10;
            pow--;
        }
//        System.out.println(sum);
        if (sum % n == 0) {
            return sum / n;
        }
        return -1;
    }
}
