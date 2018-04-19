package question;

/**
 * question
 * LeetCode
 * 2018.04.19.下午3:44
 *
 * 397. Integer Replacement
 * https://leetcode.com/problems/integer-replacement/description/
 * @author : rick
 */
class IntegerReplacement {

    public static void main(String[] args) {
        System.out.println(integerReplacement(100000000));
    }

    public static int integerReplacement(int n) {

        int temp = n;
        int count = 0;

        while (temp > 1) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else if(temp == 3 || Integer.bitCount(temp + 1) > Integer.bitCount(temp - 1)){
                temp -= 1;
            } else {
                if(temp == Integer.MAX_VALUE){
                    temp = -( (temp + 1) / 2);
                    count ++;
                } else {
                    temp += 1;
                }
            }
            count++;

        }

        return count;

    }
}
