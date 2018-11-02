package question;

/**
 * question
 * LeetCode
 * 2018.11.02.11:58
 *
 * 443. String Compression
 * https://leetcode.com/problems/string-compression/
 *
 * @author : artairs
 */
class StringCompression {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(compress(new char[]{'a'}));
//        'a','b','b','b','b','b','b','b','b','b','b','b','b'
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }

//        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int compress(char[] chars) {
        int length = 0,temp = -1,index = 0;
        char v = 0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != v){
                v = chars[i];
                chars[index] = v;
                index ++;
                length ++;
            } else {
                temp = 1;
                while (i < chars.length && chars[i] == v){
                    i ++;
                    temp ++;
                }
                length += Math.log(temp)/Math.log(10)+ 1;
                int numLength = (int)(Math.log(temp)/Math.log(10)+ 1);
                for (int j = numLength; j > 0; j--) {
                    chars[index+j - 1] = (char)(temp%10 + '0');
                    temp /= 10;
                }
                index += numLength;
                i --;
             }
        }
        return length;
    }

}
