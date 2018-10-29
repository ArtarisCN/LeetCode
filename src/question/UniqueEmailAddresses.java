package question;

import java.util.HashSet;
import java.util.Set;

/**
 * question
 * LeetCode
 * 2018.10.29.14:47
 * <p>
 * 929. Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 *
 * @author : artairs
 */
class UniqueEmailAddresses {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int numUniqueEmails(String[] emails) {
        Set<String> addr = new HashSet<>();
        for (String email : emails) {
            String[] sp = email.split("@");
            if (sp[0].indexOf("+") != 0) {
                sp[0] = sp[0].substring(0, sp[0].indexOf("+"));
            }
            sp[0] = sp[0].replace(".", "");
            addr.add(sp[0] + '@' + sp[1]);
        }

        return addr.size();
    }
}
