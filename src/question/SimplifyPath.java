package question;


import java.util.Stack;

/**
 * question
 * LeetCode
 * 2019.07.04.11:22
 * <p>
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 *
 * @author : artairs
 */
class SimplifyPath {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(simplifyPath("/home//foo/"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> pathStack = new Stack<>();
        for (String string : strings) {
            switch (string) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!pathStack.empty()) {
                        pathStack.pop();
                    }
                    break;
                default:
                    pathStack.push(string);
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!pathStack.empty()) {
            result.insert(0, pathStack.pop()).insert(0, "/");
        }
        return "".equals(result.toString()) ? "/" : result.toString();
    }

}
