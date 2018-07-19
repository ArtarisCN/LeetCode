package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.19.下午4:32
 * <p>
 * 455. Assign Cookies
 * https://leetcode.com/problems/assign-cookies/description/
 *
 * @author : rick
 */
class AssignCookies {
    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findContentChildren(new int[]{3, 1, 2}, new int[]{1, 2, 3}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findContentChildren(int[] g, int[] s) {

        int result = 0;

        List<Integer> cookies = new ArrayList<>();
        for (int i : s) {
            cookies.add(i);
        }

        List<Integer> greeds = new ArrayList<>();
        for (int i : g) {
            greeds.add(i);
        }

        Collections.sort(greeds);
        Collections.sort(cookies);

        for (Integer cookie : cookies) {
            boolean success = greeds.remove(cookie);
            if (success) {
                result++;
            } else {
                for (int i = greeds.size() - 1; i >= 0; i--) {
                    if (greeds.get(i) < cookie) {
                        greeds.remove(i);
                        result++;
                        break;
                    }
                }
            }
        }


        return result;
    }


}
