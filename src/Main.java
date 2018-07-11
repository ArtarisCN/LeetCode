/**
 * Created by rick on 2017/7/18.
 */
public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();    //获取开始时间


        int num[] = {1,2,3,4};
        System.out.println(String.valueOf(demo( num,1)));

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    private static int demo(int arr[],int n)
    {
        int i,count = 0,len = arr.length;
        for (i = 0;i < len; i++)
        {
            if(arr[i] > 2 * n)
                count += 1;
        }
        return count;
    }
}
