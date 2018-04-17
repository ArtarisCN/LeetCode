package question;

/**
 * 1
 * Created by RuiL on 2017/7/20.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        int[] result = {-1, -1};
        boolean flag = false;
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                if (nums[x] + nums[y] == target) {
                    result[0] = x;
                    result[1] = y;
                    flag = true;
                    break;
                }
            }

            if (flag)
                break;
        }

        return result;
    }
}
