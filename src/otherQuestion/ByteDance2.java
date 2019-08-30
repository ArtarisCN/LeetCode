package otherQuestion;

/**
 * otherQuestion
 * LeetCode
 * 2019.08.19.12:29
 *
 * ![](http://img.artaris.cn//blog/img/20190819125221.png)
 * @author : artairs
 */
class ByteDance2 {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(calculateWaterCapacity(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    private static int calculateWaterCapacity(int[] nums) {
        int start = nums[0],next;
        int result = 0;
        while (start < nums.length){
            next = findNextHigherIndex(nums,start);
            if(next == -1){
                start ++;
                continue;
            }

            int height = Math.min(nums[start],nums[next]);
            for (int i = start + 1;i < next;i++){
                result += height - nums[i];
            }
            System.out.println("start = "+ start + " end = " + next + " result = " + result);
            start = next;
        }
        return result;
    }


    private static int findNextHigherIndex(int[] nums, int index) {
        for (int i = index + 1;i < nums.length;i++){
            if(nums[i] >= nums[index]){
                return i;
            }
        }
        return -1;
    }


}
