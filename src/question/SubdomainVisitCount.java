package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.27.下午3:39
 * <p>
 * 811. Subdomain Visit Count
 * https://leetcode.com/problems/subdomain-visit-count/description/
 *
 * @author : rick
 */
class SubdomainVisitCount {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<String> result = subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        for (String s : result) {
            System.out.println(s);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> subdomain = new HashMap<>();

        for (String cpdomain : cpdomains) {

            String[] split = cpdomain.split(" ");
            int count = Integer.valueOf(split[0]);

            String[] domainSplit = split[1].split("\\.");

            switch (domainSplit.length) {
                case 1:

                    if (subdomain.containsKey(domainSplit[0])) {
                        subdomain.put(domainSplit[0], subdomain.get(domainSplit[0]) + count);
                    } else {
                        subdomain.put(domainSplit[0], count);
                    }

                    break;
                case 2: {

                    if (subdomain.containsKey(domainSplit[1])) {
                        subdomain.put(domainSplit[1], subdomain.get(domainSplit[1]) + count);
                    } else {
                        subdomain.put(domainSplit[1], count);
                    }

                    String domain = domainSplit[0] + "." + domainSplit[1];

                    if (subdomain.containsKey(domain)) {
                        subdomain.put(domain, subdomain.get(domain) + count);
                    } else {
                        subdomain.put(domain, count);
                    }


                    break;
                }
                case 3: {
                    if (subdomain.containsKey(domainSplit[2])) {
                        subdomain.put(domainSplit[2], subdomain.get(domainSplit[2]) + count);
                    } else {
                        subdomain.put(domainSplit[2], count);
                    }

                    String domain = domainSplit[1] + "." + domainSplit[2];

                    if (subdomain.containsKey(domain)) {
                        subdomain.put(domain, subdomain.get(domain) + count);
                    } else {
                        subdomain.put(domain, count);
                    }

                    domain = domainSplit[0] + "." + domain;

                    if (subdomain.containsKey(domain)) {
                        subdomain.put(domain, subdomain.get(domain) + count);
                    } else {
                        subdomain.put(domain, count);
                    }
                    break;
                }
                default:
                    break;
            }
        }

        List<String> result = new ArrayList<>();

        for (String s : subdomain.keySet()) {
            result.add(subdomain.get(s) + " " + s);
        }

        return result;
    }
}
