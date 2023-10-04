public class DontGiveMeFive {
    public static void main(String[] args) {
        System.out.println(dontGiveMeFive(1, 9));
        System.out.println(dontGiveMeFive(4, 17));
    }

    public static int dontGiveMeFive(int start, int end) {
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (!hasFive(i)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean hasFive(int number) {
        number = Math.abs(number);
        while (number > 0) {
            if (number % 10 == 5) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
