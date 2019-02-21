package util;

/**
 * util
 * LeetCode
 * 2018.07.13.下午4:29
 *
 * @author : rick
 */
public class SortUtils {


    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       快速排序                       =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    public static void quickSort(int[] num) {
        _quickSort(num, 0, num.length - 1);
    }

    private static void _quickSort(int[] num, int start, int end) {
        if (start >= end) {
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

            if (i < j) {
                int temp = num[j];
                num[j] = num[i];
                num[i] = temp;
            }
        }

        int temp = num[i];
        num[i] = num[start];
        num[start] = temp;

        _quickSort(num, start, i - 1);
        _quickSort(num, i + 1, end);
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       冒泡排序                       =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    public static void bubbleSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < num.length - i; j++) {
                if (num[j] > num[j + 1]) {
                    num[j + 1] = num[j + 1] + num[j];
                    num[j] = num[j + 1] - num[j];
                    num[j + 1] = num[j + 1] - num[j];
                }
            }
        }
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       插入排序                       =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    public static void insertSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int v = num[i], j;
            for (j = i; j > 0 && v < num[j - 1]; j--) {
                num[j] = num[j - 1];
            }
            num[j] = v;
        }
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       归并排序                       =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    public static void mergeSort(int[] num) {
        merge(num, 0, num.length - 1, new int[num.length]);
    }

    private static void merge(int[] num, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (end + start) / 2;
            merge(num, start, mid, temp);
            merge(num, mid + 1, end, temp);
            mergeArray(num, start, mid, end, temp);
        }
    }

    private static void mergeArray(int[] num, int start, int mid, int end, int[] temp) {
        int i = start, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (num[i] < num[j])
                temp[k++] = num[i++];
            else if (num[i] == num[j])
                temp[k++] = num[i++];
            else
                temp[k++] = num[j++];
        }

        while (i <= mid)
            temp[k++] = num[i++];

        while (j <= end)
            temp[k++] = num[j++];

        for (i = 0; i < k; i++)
            num[start + i] = temp[i];
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       选择排序                       =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    public static void selectSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            int min = i, temp;
            for (int j = num.length - 1; j > i; j--) {
                if (num[j] < num[min]) {
                    min = j;
                }
            }
            temp = num[min];
            num[min] = num[i];
            num[i] = temp;
        }
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       希尔排序                       =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    public static void shellSort(int[] num) {
        for (int gap = num.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < num.length; i++) {
                int j = i;
                while (j - gap > 0 && num[j] < num[j - gap]) {
                    num[j] = num[j] + num[j - gap];
                    num[j - gap] = num[j] - num[j - gap];
                    num[j] = num[j] - num[j - gap];
                    j = j - gap;
                }
            }
        }
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       堆排序                         =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    private static void buildMaxHeap(int[] num, int start, int end) {
        int father = start, son = start * 2 + 1;
        while (son <= end) {
            if (son + 1 < end && num[son] < num[son + 1]) {
                son++;
            }

            if (num[father] <= num[son]) {
                num[father] = num[father] + num[son];
                num[son] = num[father] - num[son];
                num[father] = num[father] - num[son];
            }
            return;
        }
    }

    public static void heapSort(int[] num) {
        for (int i = num.length / 2 - 1; i >= 0; i--) {
            buildMaxHeap(num, i, num.length - 1);
        }


        for (int i = num.length - 1; i > 0; i--) {
            num[i] = num[i] + num[0];
            num[0] = num[i] - num[0];
            num[i] = num[i] - num[0];

            buildMaxHeap(num, 0, i - 1);
        }
    }


    public static void bucketSort(int[] num) {
        if (num == null || num.length < 2) {
            return;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : num) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] bucket = new int[max - min + 1];

        for (int i : num) {
            bucket[i - min]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                num[index++] = i + 1;
            }
        }
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       基数排序                        =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================
    public static void radixSort(int[] num) {
        if(num.length == 0)
            return;

        int maxV = num[0];

        for (int i : num) {
            if (maxV < i) {
                maxV = i;
            }
        }

        for (int i = 1; maxV / i > 0; i *= 10) {
            radixSortHelp(num, i);
        }
    }

    private static void radixSortHelp(int num[], int exp) {
        int[] output = new int[num.length];             // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];
        // 将数据出现的次数存储在buckets[]中
        for (int aNum : num){
            buckets[(aNum / exp) % 10]++;
        }

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        // 将数据存储到临时数组output[]中
        for (int i = num.length - 1; i >= 0; i--) {
            output[buckets[(num[i] / exp) % 10] - 1] = num[i];
            buckets[(num[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给a[]
        System.arraycopy(output, 0, num, 0, num.length);
    }
}
