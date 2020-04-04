package earth.bermuda.leetcode;

/**
 * Created by james on 03/04/2020.
 */
public class MaximumSubArray {
    public int validate(int[] nums) {
        Integer min = 0;
        Integer max = null;
        Integer max_since_min = null;
        Integer min_before_max = null;
        Integer largest = null;
        Integer cum = 0;
        Integer range = null;

        for (int i = 0; i < nums.length; i++) {
            cum += nums[i];
            if (cum < min) {
                if (max_since_min != null && (range == null || max_since_min - min > range)) {
                    range = max_since_min - min;
                }
                min = cum;
                max_since_min = null;
            } else if (max_since_min == null || cum > max_since_min) {
                max_since_min = cum;
                if (max == null || cum > max) {
                    max = cum;
                    min_before_max = min;
                }
            }
            if (largest == null || largest < nums[i]) {
                largest = nums[i];
            }
        }
        int toReturn = largest;
        if (range != null) {
            toReturn = Math.max(toReturn, range);
        }
        if (max != null && min_before_max != null) {
            toReturn = Math.max(toReturn, max - min_before_max);
        }
        if (max_since_min != null && min != null) {
            toReturn = Math.max(toReturn, max_since_min - min);
        }
        return toReturn;
    }


    public int maxSubArray(int[] nums) {
        int min = 0;
        int max = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        int range = Integer.MIN_VALUE;
        int cum = 0;
        boolean minSetLastTick = false;

        for (int num : nums) {
            cum += num;
            if (cum <= min) {
                min = cum;
                minSetLastTick = true;
            }
            else if (minSetLastTick) {
                minSetLastTick = false;
                max = cum;
            }
            else if (cum >= max) {
                max = cum;
                range = Math.max(range, max - min);
            }
            if (num > largest) {
                largest = num;
            }
        }

        return Math.max(range, largest);
    }
}
