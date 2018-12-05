package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.12.05.10:00
 * <p>
 * 405. Convert a Number to Hexadecimal
 * https://leetcode.com/problemset/all/?difficulty=Easy&status=Todo
 *
 * @author : artairs
 */
class ConvertANumberToHexadecimal {

    static Map<Integer, Character> mapInt = new HashMap<>();
    static Map<Character, Integer> mapChar = new HashMap<>();

    static {
        mapInt.put(0, '0');
        mapInt.put(1, '1');
        mapInt.put(2, '2');
        mapInt.put(3, '3');
        mapInt.put(4, '4');
        mapInt.put(5, '5');
        mapInt.put(6, '6');
        mapInt.put(7, '7');
        mapInt.put(8, '8');
        mapInt.put(9, '9');
        mapInt.put(10, 'a');
        mapInt.put(11, 'b');
        mapInt.put(12, 'c');
        mapInt.put(13, 'd');
        mapInt.put(14, 'e');
        mapInt.put(15, 'f');

        mapChar.put('0', 0);
        mapChar.put('1', 1);
        mapChar.put('2', 2);
        mapChar.put('3', 3);
        mapChar.put('4', 4);
        mapChar.put('5', 5);
        mapChar.put('6', 6);
        mapChar.put('7', 7);
        mapChar.put('8', 8);
        mapChar.put('9', 9);
        mapChar.put('a', 10);
        mapChar.put('b', 11);
        mapChar.put('c', 12);
        mapChar.put('d', 13);
        mapChar.put('e', 14);
        mapChar.put('f', 15);
    }

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(toHex(-1000));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        } else if (num > 0) {
            StringBuilder sb = new StringBuilder();
            while (num >= 16) {
                sb.append(mapInt.get(num % 16));
                num = num / 16;
            }

            sb.append(mapInt.get(num));
            return sb.reverse().toString();
        } else {
            StringBuilder result = new StringBuilder();

            StringBuilder sb = new StringBuilder();

            num = Math.abs(num) - 1;
            while (num >= 16) {
                sb.append(mapInt.get(num % 16));
                num = num / 16;
            }
            sb.append(mapInt.get(num));
            sb.reverse();

            if (sb.toString().length() < 8) {
                StringBuilder zeroSb = new StringBuilder();
                int i = 8 - sb.toString().length();
                while (i > 0) {
                    zeroSb.append('0');
                    i--;
                }
                sb.insert(0, zeroSb);
            }

            String ffff = "ffffffff";
            for (int i = 0; i < 8; i++) {
                result.append(mapInt.get(mapChar.get(ffff.charAt(i)) - mapChar.get(sb.charAt(i))));
            }
            return result.toString();
        }

    }

}
