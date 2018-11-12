package question;

/**
 * question
 * LeetCode
 * 2018.11.12.15:38
 * <p>
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author : artairs
 */
class ContainerWithMostWater {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


//        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 2}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = Math.min(height[left], height[right]) * (right - left);
        int curLeft = height[left], curRight = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                if (right <= left || curLeft >= height[left]) {
                    continue;
                } else {
                    if (Math.min(height[left], height[right]) * (right - left) > max) {
                        max = Math.min(height[left], height[right]) * (right - left);
                        curLeft = height[left];
                    }
                }


            } else {
                right--;
                if (right <= left || curRight >= height[right]) {
                    continue;
                } else {
                    if (Math.min(height[left], height[right]) * (right - left) > max) {
                        max = Math.min(height[left], height[right]) * (right - left);
                        curRight = height[right];
                    }
                }
            }
        }

        return max;
    }

}
