package question;

/**
 * question
 * LeetCode
 * 2018.07.12.下午6:14
 *
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/description/
 *
 * @author : rick
 */
class AddBinary {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println(addBinary2("11",
                "1"));

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String addBinary2(String a, String b) {
        char[] aArr = a.toCharArray(),bArr = b.toCharArray();

        int length = Math.max(a.length(),b.length());

        StringBuilder sb = new StringBuilder();
        if(a.length() > b.length()){
            sb.append(b);
            sb.reverse();

            for (int i = a.length() - b.length(); i > 0; i --){
                sb.append("0");
            }

            bArr = sb.reverse().toString().toCharArray();
        } else {
            sb.append(a);
            sb.reverse();

            for (int i = b.length() - a.length(); i > 0; i --){
                sb.append("0");
            }

            aArr = sb.reverse().toString().toCharArray();
        }

        sb = new StringBuilder();

        int sub = 0;

        for (int i = 1; i < length + 1; i++) {

            int aVar = Integer.valueOf(String.valueOf(aArr[aArr.length  - i]));
            int bVar = Integer.valueOf(String.valueOf(bArr[bArr.length  - i]));

            if(aVar + bVar + sub == 3){
                sb.append("1");
                sub = 1;
            } else if(aVar + bVar + sub == 2){
                sb.append("0");
                sub = 1;
            } else {
                sb.append(String.valueOf(aVar + bVar + sub));
                sub = 0;
            }
        }

        if(sub == 1){
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    public static String addBinary(String a, String b) {

        long resultVal =  string2Binary(a) + string2Binary(b);

        StringBuilder sb = new StringBuilder();
        for (long n = resultVal; n > 0 ; n /= 2) {
            sb.append(n %  2);
        }

        String result = sb.reverse().toString();

        return "".equals(result) ?"0":result;
    }


    public static long string2Binary(String s) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum += 1;
            }
            sum <<= 1;
        }
        sum >>= 1;

        return sum;
    }
}
