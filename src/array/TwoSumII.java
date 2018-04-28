package array;

import java.util.Arrays;

import com.sun.tools.javac.util.Assert;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int sum;
        while ((sum = numbers[i] + numbers[j]) != target) {
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] { i + 1, j + 1 };
    }

    public static void main(String[] args) {
        Assert.check(Arrays.equals(new int[] { 1, 2 }, new TwoSumII().twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }
}
