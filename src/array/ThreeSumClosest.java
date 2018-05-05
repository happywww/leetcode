package array;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * strategy same as three sum problem, except use one variable to keep track of the closet sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minSum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(minSum - target)) {
                    minSum = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    }

}
