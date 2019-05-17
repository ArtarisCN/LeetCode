package question;

import java.util.LinkedList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.05.09.17:38
 *
 * @author : artairs
 */
class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = 0;
        List<Integer> merge = new LinkedList<>();
        int length1 = nums1.length,length2 = nums2.length;
        int i = 0 ,j = 0;
        boolean flag = true;
        while (flag){

            if(i < length1 && j < length2){
                if(nums1[i] < nums2[j] ){
                    merge.add(nums1[i]);
                    i++;
                    continue;
                } else {
                    merge.add(nums2[j]);
                    j++;
                    continue;
                }
            }

            if(i == length1 && j < length2){
                merge.add(nums2[j]);
                j++;
                continue;
            }

            if(i < length1 && j == length2){
                merge.add(nums1[i]);
                i++;
                continue;
            }


            if(i == length1 && j == length2){
                flag = false;
            }
        }

        if(merge.size() > 0) {
            if (merge.size() % 2 == 1) {
                middle = merge.get(merge.size() / 2);
            } else {
                middle = ((float) (merge.get(merge.size() / 2 - 1) + merge.get(merge.size() / 2))) / 2;
            }
        }


        return middle;
    }

}
