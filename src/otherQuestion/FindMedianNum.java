package otherQuestion;

/**
 * otherQuestion
 * LeetCode
 * 2019.06.18.10:54
 *
 * 一个无序数组找到中位数
 * @author : artairs
 */
class FindMedianNum {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] arr = new int[]{1,3,5,7,9,8,6,4,2,0,10};
//        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println(GetMidNumNoSort1(arr,arr.length));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    static int PartSort(int[] arr, int start, int end){
        int left = start;
        int right = end;
        int key = arr[end];   //选取关键字
        while (left < right)         {
            while (left < right && arr[left] <= key)  //左边找比key大的值
            {
                ++left;
            }
            while (left < right && arr[right] >= key)  //右边找比key小的值
            {
                --right;
            }
            if (left < right)
            {
                swap(arr,left, right);  //找到之后交换左右的值
            }
        }
        swap(arr,right, end);  //找到之后交换左右的值
        return left;
    }
    //求一个无序数组的中位数
    static int GetMidNumNoSort1(int[] arr,int size)
    {
        int start = 0;
        int end = size - 1;
        int mid = (size - 1) / 2;
        int div = PartSort(arr,start,end);
        while (div != mid)
        {
            if (mid < div)   //左半区间找
                div = PartSort(arr, start, div - 1);
            else    //左半区间找
                div = PartSort(arr, div + 1, end);
        }
        return arr[mid];   //找到了
    }

    public static void swap(int[] array,int left,int right){
        int swap =  array[left];
        array[left] =  array[right];
        array[right] = swap;

//        array[left] += array[right];
//        array[right] = array[left] - array[right];
//        array[left] = array[left] - array[right];
    }
}
