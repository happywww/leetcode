package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.sun.tools.javac.util.Assert;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Assert.check(Arrays.equals(new int[] { 0, 1 }, new TwoSum().twoSum(new int[] { 3, 3 }, 6)));
    }
}
