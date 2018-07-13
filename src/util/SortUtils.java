package util;

/**
 * util
 * LeetCode
 * 2018.07.13.下午4:29
 *
 * @author : rick
 */
class SortUtils {

    public static void quickSort(int[] num) {
        sort(num,0,num.length - 1);
    }

    public static void sort(int[] num,int start,int end){
        if(start >= end){
            return;
        }

        int t = num[start];

        int i = start, j = end;

        while (j != i) {

            while (j > i && num[j] >= t) {
                j--;
            }

            while (j > i && num[i] <= t) {
                i++;
            }

            if(i<j) {
                int temp = num[j];
                num[j] = num[i];
                num[i] = temp;
            }
        }

        int temp = num[i];
        num[i] = num[start];
        num[start] = temp;

        sort(num,start,i  - 1);
        sort(num,i+ 1,end);
    }
}
