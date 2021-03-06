package question;

/**
 * question
 * LeetCode
 * 2018.07.20.下午1:37
 *
 * 168. Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 * @author : rick
 */
class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(convertToTitle(28));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int num = n % 26;
            if(num == 0){
                sb.insert(0,"Z");
                n -= 26;
            } else {
                char x = (char) (num + 'A' - 1);
                sb.insert(0,x);
                n -= n % 26;
            }
            n /= 26;
        }
        return sb.toString();
    }

}
