package otherQuestion;

/**
 * otherQuestion
 * LeetCode
 * 2019.07.15.15:58
 *
 * @author : artairs
 */
class FuzzySqrt2 {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(fuzzy());

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


     static double fuzzy(){
        final double EPSINON = 0.0000000001;
        double er = 2;
        double start = 1.414;
        double end = 1.415;
        double mid = 0;

        while (end - start  > EPSINON) {
            mid = (start + end) / 2;
            double result = mid * mid;
            if(result > er){
                end = mid;
            } else {
                start = mid;
            }
        }

        return mid;

    }

}
