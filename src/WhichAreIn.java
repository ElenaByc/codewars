import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/*
6 kyu
Which are in?
https://www.codewars.com/kata/550554fd08b86f84fe000a58/
*/
public class WhichAreIn {
    public static void main(String[] args) {
        String[] a = new String[]{"arp", "live", "strong"};
        String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        System.out.println(Arrays.toString(WhichAreIn.inArray(a, b))); // {"arp", "live", "strong"}
    }

    public static String[] inArray(String[] array1, String[] array2) {
        List<String> list = new ArrayList<>();
        for (String str : array1) {
            if (isSubstr(str, array2)) {
                list.add(str);
            }
        }
        Collections.sort(list);
        int n = list.size();
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static boolean isSubstr(String str, String[] array2) {
        for (String s : array2) {
            if (s.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
