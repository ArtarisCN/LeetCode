package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.07.13.下午6:34
 *
 * 401. Binary Watch
 * https://leetcode.com/problems/binary-watch/submissions/
 *
 * @author : rick
 */
class BinaryWatch {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArrayList(readBinaryWatch(4));

        compare(new String[]{
                },
                new String[]{
                });

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<String> readBinaryWatch(int num) {
        if (num > 8) {
            return new ArrayList<>();
        }

        String[] topZero = new String[]{"0"};
        String[] topOne = new String[]{"1", "2", "4", "8"};
        String[] topTwo = new String[]{"3", "5", "9", "6", "10"};
        String[] topThree = new String[]{"7","11"};

        String[] endZero = new String[]{":00"};
        String[] endOne = new String[]{":01", ":02", ":04", ":08", ":16", ":32"};
        String[] endTwo = new String[]{
                ":03", ":05", ":09", ":17", ":33",
                ":06", ":10", ":18", ":34",
                ":12", ":20", ":36",
                ":24", ":40",
                ":48"};
        String[] endThree = new String[]{
                ":07", ":11", ":19", ":35",
                ":13", ":21", ":37",
                ":25", ":41",
                ":49",
                ":14", ":22", ":38",
                ":26", ":42",
                ":50",
                ":28", ":44",
                ":52",
                ":56"};
        String[] endFour = new String[]{
                ":58", ":54", ":46", ":30",
                ":57", ":53", ":45", ":29",
                ":51", ":43", ":27",
                ":39", ":23",
                ":15"};

        String[] endFive = new String[]{":59", ":55", ":47", ":31"};


        List<String> result = new ArrayList<>();
        int hour = 0, minute = num - hour;
        while (hour < 4 && minute >= 0) {
            if (minute > 5) {
                hour++;
                minute = num - hour;
                continue;
            }
            String[] hourStr, minuteStr;
            switch (hour) {
                case 0: hourStr = topZero;break;
                case 1: hourStr = topOne;break;
                case 2: hourStr = topTwo;break;
                case 3: hourStr = topThree;break;
                default: hourStr = topZero;break;
            }

            switch (minute) {
                case 0: minuteStr = endZero;break;
                case 1: minuteStr = endOne;break;
                case 2: minuteStr = endTwo;break;
                case 3: minuteStr = endThree;break;
                case 4: minuteStr = endFour;break;
                case 5: minuteStr = endFive;break;
                default: minuteStr = endZero;break;
            }
            sum(result,hourStr,minuteStr);

            hour++;
            minute = num - hour;
        }
        return result;
    }

    private static void sum(List<String> result, String[] hour, String[] minute) {
        for (String h : hour) {
            for (String m : minute) {
                result.add(h+m);
            }
        }
    }

    private static void compare(String[] s1,String[] s2){
        List<String> strings1 = Arrays.asList(s1);
        List<String> strings2 = Arrays.asList(s2);

        for (String s : strings1) {
            if(!strings2.contains(s)){
                System.out.println(s);
            }
        }

        System.out.println();

        for (String s : strings2) {
            if(!strings1.contains(s)){
                System.out.println(s);
            }
        }
    }

}

