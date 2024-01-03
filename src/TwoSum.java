import java.util.Arrays;
import java.util.HashMap;

/*
6 kyu
Two Sum
https://www.codewars.com/kata/52c31f8e6605bcc646000082/
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        int[] nums2 = {1234, 5678, 9012};
        int target2 = 14690;
        int[] nums3 = {2, 2, 3};
        int target3 = 4;
        int[] nums4 = {2, 3, 1};
        int target4 = 4;
        System.out.println(Arrays.toString(twoSum(nums1, target1)));
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
        System.out.println(Arrays.toString(twoSum(nums3, target3)));
        System.out.println(Arrays.toString(twoSum(nums4, target4)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = numbers.length;
        int num;

        for (int i = 0; i < n; i++) {
            num = target - numbers[i];
            if (hm.containsKey(num)) {
                return new int[]{hm.get(num), i};
            }
            hm.put(numbers[i], i);
        }
        return null;
    }
}
