package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午3:14
 *
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/description/
 *
 * @author : rick
 */
class FirstBadVersion {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(String.valueOf(firstBadVersion(3)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int firstBadVersion(int n) {

        int start = 1,end = n;

        if(isBadVersion(start) && isBadVersion(end)){
            return 1;
        }

        while ( end > start + 1){

            int temp = start +  (end - start)/2;

            if((isBadVersion(start) ^ isBadVersion(temp))){
                end = start +  (end - start)/2;
            } else if((isBadVersion(temp) ^ isBadVersion(end))){
                start = start +  (end - start)/2;
            }
        }

        if(isBadVersion(start)){
            return start;
        } else {
            return end;
        }
    }

    public static boolean isBadVersion(int version){
        return version > 2;
    }

}
