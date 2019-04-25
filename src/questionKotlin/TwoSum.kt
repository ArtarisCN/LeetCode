package questionKotlin

import java.util.*

/**
 * kotlin
 * LeetCode
 * 2019.04.25.15:05
 *
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 *
 * @author : artairs
 */
class TwoSum {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //获取开始时间
            val startTime = System.currentTimeMillis()

            for (j: Int in 1..10000) {

                for (i in twoSum(intArrayOf(15, 50, 74, 88, 91, 66, 36, 88, 23, 13, 22, 17, 56, 57, 52, 59, 80, 78, 73, 19, 53, 28, 65, 72, 67, 31, 48, 92, 0, 28, 74, 95, 16, 73, 44, 94, 87, 68, 6, 29, 55, 0, 39, 71, 31, 2, 85, 15, 62, 0, 58, 36, 19, 8, 59, 45, 25, 52, 45, 48, 46, 57, 22, 54, 88, 34, 53, 77, 11, 71, 30, 56, 0, 51, 24, 63, 92, 32, 87, 83, 46, 26, 98, 93, 34, 71, 94, 12, 33, 38, 26, 28, 90, 53, 79, 39, 59, 26, 55, 52, 10), 6)) {
                    println(i)
                }
            }


            //获取结束时间
            val endTime = System.currentTimeMillis()
            println("程序运行时间： " + (endTime - startTime) + "ms")
        }

        fun twoSum(nums: IntArray, target: Int): IntArray {
            val source = HashMap<Int, Int>()

            for (index in nums.indices) {
                if (source.containsKey(target - nums[index])) {
                    return intArrayOf(source[target - nums[index]]!!, index)
                }
                source[nums[index]] = index
            }

            return intArrayOf(-1, -1)
        }
    }
}