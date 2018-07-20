package question;

/**
 * question
 * LeetCode
 * 2018.07.20.下午3:02
 *
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * @author : rick
 */
class ReverseBits {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(reverseBits2(  43261596));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

/*    public static int reverseBits(int n) {
        List<Integer> integers = new ArrayList<>();

        int temp = n;
        while (temp != 0) {

            integers.add(temp % 2);
            temp = temp / 2;
        }


        while (integers.size() != 32){
            integers.add(0);
        }

        StringBuilder sb = new StringBuilder();

        for (Integer integer : integers) {
            sb.append(integer);
        }

        return Long.valueOf(sb.toString(),2).intValue() ;

    }*/

    public static int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if( (( n>>i ) & 1) == 1){

                result = result | (1<< (31 - i));
            }
        }
        return result;
    }

}

