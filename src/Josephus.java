import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {
        System.out.println(josephusPermutation(new ArrayList(Arrays.asList(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})), 2));
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();
        int n = items.size();
        boolean[] live = new boolean[n];
        Arrays.fill(live, true);
        int counter = 0;
        int index = 0;
        while (result.size() < n) {
            if (live[index]) {
                counter++;
                if (counter == k) {
                    live[index] = false;
                    result.add(items.get(index));
                    counter = 0;
                }
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }

        return result;
    }
}
