package question;

/**
 * question
 * LeetCode
 * 2018.10.30.14:07
 *
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 *
 * @author : artairs
 */
class BinarySearch {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(search(new int[]{3,9},9));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int search(int[] nums, int target) {
        int start = 0,end = nums.length - 1;

        while (start < end){
            if(nums[(start + end)/2] == target){
                return (start + end)/2;
            } else if(nums[(start + end)/2] < target){
                start = (start + end)/2 + 1;
            } else {
                end = (start + end)/2 - 1;
            }
        }
        if(start == end){
            return nums[start] == target?0:-1;
        }
        return -1;
    }



}
