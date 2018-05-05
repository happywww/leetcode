package array;

import java.util.HashMap;
import java.util.Map;

import com.sun.tools.javac.util.Assert;

public class FourSumCount {

    /**
     * like two sum, use set to reduce time complexity to O(n^2)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        // Map<A+B, count>
        Map<Integer, Integer> map = new HashMap<>();
        // count A+B
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // count C+D = -(A+B)
        for (int c : C) {
            for (int d : D) {
                count += map.getOrDefault(-c - d, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Assert.check(new FourSumCount()
            .fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 }, new int[] { 0, 2 }) == 2);
    }
}
