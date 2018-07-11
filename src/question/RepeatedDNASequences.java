package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.07.11.上午10:00
 *
 * 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * @author : rick
 */
class RepeatedDNASequences {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<String> sequences = findRepeatedDnaSequences2("");

        for (String sequence : sequences) {
            System.out.println(sequence);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    /**
     * 超时
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {

        List<String> sequences = new ArrayList<>();

        if(s.length() < 11){
            return sequences;
        }

        for (int i = 0; i <= s.length() - 1 - 10 ; i++){
            String subString = s.substring(i,i + 10);

            if(sequences.contains(subString)){
                continue;
            }

            String otherString = s.substring(i+1);

            if(otherString.contains(subString)){
                sequences.add(subString);
            }
        }

        return sequences;
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        if (len < 10){
            return list;
        }
        String str = s.substring(0, 10);
        Map<String, Integer> map = new HashMap<>();
        map.put(str, 1);
        for (int i = 1; i < len; ++ i){
            if (i + 10 > len){
                break;
            }
            str = s.substring(i, i + 10);
            if (map.containsKey(str)){
                int index = map.get(str);
                if (index == 1){
                    list.add(str);
                }
                map.put(str, index + 1);
            }
            else {
                map.put(str, 1);
            }
        }
        return list;
    }


}
