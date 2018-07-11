package question;

/**
 * question
 * LeetCode
 * 2018.07.11.下午6:33
 *
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * @author : rick
 */
class SearchInsertPosition {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(searchInsert(new int[]{1,3,5,6},2)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int searchInsert(int[] nums, int target) {

        if(target < nums[0]){
            return 0;
        }

        if(target > nums[nums.length - 1]){
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]){
                return i;
            } else if(target > nums[i] && target < nums[i + 1]){
                return i + 1;
            }
        }

        return 0;
    }
}
