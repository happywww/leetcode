package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /**
     * same as three sum problem
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < nums.length - 3; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // optimization
            if (nums[first] * 4 > target) {
                continue;
            }
            for (int second = first + 1; second < nums.length - 2; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // optimization
                if (nums[first] + nums[second] * 3 > target) {
                    continue;
                }
                int l = second + 1;
                int r = nums.length - 1;
                while (l < r) {
                    // optimization
                    if (nums[first] + nums[second] + nums[l] * 2 > target
                        || nums[first] + nums[second] + nums[r] * 2 < target) {
                        break;
                    }

                    int sum = nums[first] + nums[second] + nums[l] + nums[r];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[first], nums[second], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
    }
}
