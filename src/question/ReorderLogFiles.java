package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.11.12.10:34
 * <p>
 * 937. Reorder Log Files
 * https://leetcode.com/problems/reorder-log-files/
 *
 * @author : artairs
 */
class ReorderLogFiles {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printf(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String[] reorderLogFiles(String[] logs) {
        String[] temp = new String[logs.length];
        mergeSort(logs, 0, logs.length - 1, temp);
        return temp;
    }


    private static void mergeSort(String[] a, int first, int last, String[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, temp);    //左边有序
            mergeSort(a, mid + 1, last, temp); //右边有序
            mergeArray(a, first, mid, last, temp); //再将二个有序数列合并
        }
    }


    private static void mergeArray(String[] a, int first, int mid, int last, String[] temp) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;

        while (i <= m && j <= n) {
            if (compare(a[i], a[j]) == 0)
                temp[k++] = a[i++];
            else if (compare(a[i], a[j]) == 1)
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    /**
     * @param a
     * @param b
     * @return 0 ==
     * -1 <
     * 1 >
     */
    private static int compare(String a, String b) {
        String realA = a.substring(a.indexOf(" ") + 1);
        String realB = b.substring(b.indexOf(" ") + 1);

        char c1 = realA.charAt(0);
        char c2 = realB.charAt(0);

        if (c1 <= '9' && c1 >= '0' && c2 <= '9' && c2 >= '0') {
            return 0;
        }

        if (c1 <= 'z' && c1 >= 'a' && c2 <= '9' && c2 >= '0') {
            return 1;
        }

        if (c1 <= '9' && c1 >= '0' && c2 <= 'z' && c2 >= 'a') {
            return -1;
        }

        if (c1 <= 'z' && c1 >= 'a' && c2 <= 'z' && c2 >= 'a') {
            int compare = realA.compareTo(realB);
            if (compare == 0) {
                return 0;
            } else if (compare > 0) {
                return -1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
