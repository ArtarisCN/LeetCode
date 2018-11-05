package question;

import java.util.Arrays;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.11.05.15:41
 * <p>
 * 720. Longest Word in Dictionary
 * https://leetcode.com/problems/longest-word-in-dictionary/
 *
 * @author : artairs
 */
class LongestWordInDictionary {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println("riwisyimddyguitvtdwgyzuimf".length());
        System.out.println("lemdqgqwumegvfexckxgiadwlc".length());

        System.out.println(longestWord(new String[]{"aq","a", "banana", "app", "appl", "ap", "apply", "apple"}));
//        System.out.println(longestWord(new String[]{"w","wo","wor","worl", "world"}));
//        System.out.println(longestWord(new String[]{"b", "br", "bre", "brea", "break", "breakf", "breakfa", "breakfas", "breakfast", "l", "lu", "lun", "lunc", "lunch", "d", "di", "din", "dinn", "dinne", "dinner"}));
//        System.out.println(longestWord(new String[]{"k","lg","it","oidd","oid","oiddm","kfk","y","mw","kf","l","o","mwaqz","oi","ych","m","mwa"}));
//        System.out.println(longestWord(new String[]{"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"}));

//        System.out.println(longestWord(new String[]{"aq","sqmhtpcgdsdfqgxsjgqiz","kcudnb","erkuf","o","uv","vg","ixlfvbv","itcudluaycsspjrohf","paqwiazmmvgu","riwisyi","riwisyimddyguit","mnexyhlutcl","fcnde","japawo","vgirdgjsz","volzppbtszdnoo","kcudnbvfugbntkdgjstx","kcud","zaydypc","ovly","yizslwlpndzjihonftle","qfhggvatefvwm","riwisyimdd","sqmhtpcgdsdf","qd","cxt","vgirdgjszo","nz","gslbknc","ctguxtac","hklbpjmcedqcwnbuow","omqndxpxevxojfws","ncghfsccrgqkafho","ahx","nzwwarlivffi","paqw","hzzpjoossvzg","paqwiazmmvgudly","yfxsv","riwisyimddyg","riwis","paqwi","yfxs","sqmh","tp","riwisyimddyguitvtd","tpktncgausglcelnp","hklbpjmce","uvdfwryvvugthazsf","dkwpd","asglpcpgctp","kcudnbvfugbntkdg","zaydyp","kcudnbvfugb","as","volzppbtszdnoocqyl","japawosnoiobnrfj","ja","yizslwlpndzjihonf","japawos","itc","fukwsv","vo","ctguxta","ri","tveepjwp","lemdqgqwumegvfexck","ixlfvbvdzwndvfi","fcndec","momqxnld","wv","zaydypcbfttm","omqndxpxevxoj","nzwwarlivf","qdowgpmdjc","fukws","ixlfvbvdzwndvf","asglpcpgctpd","lemdqgqwumegvf","gsl","fc","uiuw","volz","vol","mnexyhlutclbwvvcgdzec","kc","dkwpdp","qfh","yizslwlpnd","riwisyimddyguitvt","lemdqgqwu","yiz","japawosnoiobnrfjr","er","qfhggvatefvwmqbxt","asgl","ovl","kcudnbvfugbnt","mnexyhlutclbwvvcgdzecs","mnexyhlutclbwvvcgdze","e","paqwiazmmvgudl","p","zfzpuxg","sqmhtpc","paqwiazmmvgudlyuwa","itcudluaycs","eurmr","xao","omqndxp","qfhggvatefvwmqb","l","hzzp","i","lemdq","tpktncgausgl","yizslwlpndz","hzzpjooss","tveepjwpmg","ix","wqmwehunbuzf","eur","ahxm","asglpcpgctpdcehwte","xtwmnupebcuzbg","bfbh","kcu","vgirdg","paqwiazmmv","riwisyimddygu","itcudluayc","volzppbtszdno","eurmricm","vgird","sqmhtpcgdsdfqgxsj","kcudnbvf","xtwmnupebcuz","sqmht","volzppbtszdnoocqylo","tpktncgausg","tpktnc","asglpcpgctpdcehw","gslbknct","qfhggvatefvwmq","h","za","lemdqgqwumegvfexckxgiadwl","tpktncgausglcelnpno","hzzpjo","omqndxpxevxo","qfhggvatefvwmqbx","n","riwisyim","xtwmn","mnexy","uvd","qfhggva","yizslwlpn","gs","erku","sq","hz","riwi","xtw","kcudnbvfugbn","nzwwarli","t","qf","gk","hzzpjoossvzgygxh","kcudnbvfu","gslbkn","yizslwlpndzjiho","yizslwlpndzji","hklbpjmcedqcwn","wqm","hklbpjmcedqcwnbuowttik","uw","vgi","g","lemdqgqwumegvfexc","mn","ncghfsccrgqkafhoa","hzzpjoossvzgygxhgsiyd","aw","volzppbt","gkxzjueyofw","hklbpjmcedqcwnbuo","xt","paqwiazm","tveep","itcudluaycssp","bq","momq","uiuwyorgmesml","uvdfw","yfx","lemdqgqwum","yizslwlp","ixlfvbvd","bf","japawosnoiobnr","tv","ctg","tpk","zfzpuxgh","itcudluaycsspjrohfr","r","cxtos","gkxzj","yf","riwisy","wqmwehunbuzfhp","japawosnoiobnrfjrsbrc","zfzp","ncghf","momqxnl","mnexyhlutclbwvvcgd","asglpcpgctpdceh","q","lem","d","dkwpdpvy","yizslwlpndzjihon","asglpc","qfhggvate","nc","snv","tveepjwpmghviayy","ixlfv","m","ct","zf","mom","hklbp","yfxsvgari","tpktncgau","fcn","ncghfsccrgqka","bqw","wqmwehunbuzfhpi","tveepjwpmghviay","xtwm","bfb","japawosnoiob","bfbhn","uvdfwryvvu","wqmwehun","itcudlua","wqmwehunbuzfhpia","asglpcpgctpdc","volzp","le","ncg","paqwiazmmvg","tvee","uvdfwryvvugthaz","japawosnoiobnrfjrsbr","wvepj","lemdqgqwumegvfexckxgiadw","dkwp","uvdfwryvvugthazsfqukaik","uvdfwryvvugthazsfqukaikv","bfbhnenn","lemdqgqw","japawosnoiobnrfjrsb","cx","eurmricmwbul","kcudnbvfugbntkdgjs","dkwpdpv","uiuwyor","ncghfsccrg","lemdqgqwumegvfexckxg","riwisyimddy","sqmhtpcgdsdfqg","pg","paq","volzppbtszd","hzzpjoossvzgygxhgsiy","ctgu","kei","qdowgpmd","qv","zaydypcb","japawosnoio","mne","je","k","omqnd","sqmhtpcgdsdfqgxsjgqi","qfhggvat","volzppb","hzzpjoossvzgygx","uiuwyorgmesm","qdowgpmdjcowemkacwz","riwisyimddyguitvtdwgyzui","lemdqgqwumegvfexckxgi","uvdfwryvvugthazsfquk","nzw","zfzpuxghs","hk","paqwia","hzzpjoossv","mnexyhlutclbwv","wqmweh","xtwmnu","ixlfvbvdzwndvfir","mnex","sqmhtpcgdsd","riwisyimddyguitvtdwgyzu","omqndxpxevxojfw","qdo","sn","xtwmnupe","hzzpjoossvzgygxhg","it","ctguxt","japaw","xtwmnupeb","uvdfwr","gkxzjuey","omqn","sqmhtpcgdsdfqgx","j","ncghfsccrgqk","lemdqgqwumeg","lemdqg","asglpcpg","uvdfwryvvugthazsfquka","ncghfsccrgqkaf","itcudluaycsspjr","tpktncgausglcelnpn","vgir","hzzpjoossvzgy","jeq","c","qfhggvatefvwmqbxtdnb","lemdqgqwumegvfexckxgiad","cxtoslem","hklbpjmcedqcwnbuowtti","japawosno","omqndxpx","uwp","rju","omqndx","xtwmnupebcu","riwisyimddygui","riwisyimddyguitvtdwgyz","zfzpuxghsfme","fcnd","volzppbtszdnoocqylol","japawosnoiobn","itcudluaycsspjrohfrni","mnexyhlut","zfz","volzppbts","sqmhtpcgdsdfqgxs","wqmwe","ixlfvb","itcudlu","gslb","erkufyp","mnexyhlutclbwvvcgdzecsu","eurmricmwb","gkx","tpkt","qfhggvatefvwmqbxtd","nzwwa","ncghfsccrgqkafh","qdowgpmdjcowemkacw","erkufypwnu","qdowgpmdjcowemkacwzo","riwisyimddyguitvtdwgyzuim","wqmwehunb","hklbpjm","zaydy","uvdfwry","b","gslbknctqwk","gslbknctqw","qfhg","japa","fcndecv","jap","qdowgpmdjcowem","yizsl","uvdfwryvvugthazsfq","uiuwy","mnexyhlutclbwvv","asglpcpgc","bqwkbp","gkxzju","japawosnoi","momqxn","hzzpjoossvzgygxhgs","pgd","uiuwyorg","hzzpjoossvzgygxhgsiyduod","jeqx","xaoq","kcudnbvfugbntkdgj","hklbpjmcedqcwnbuowttikv","japawosnoiobnrfjrsbrcu","mnexyhl","sqmhtpcgds","itcudluaycss","asglpcpgctpdce","qdowgpmdjcowemka","lemd","itcudluay","cxtoslemgfyjfzs","sqmhtpcg","ixlf","eurm","wvep","dkw","uvdfwryvvugthazs","zfzpu","itcudluaycsspjrohfrn","aqfmw","tveepjwpmgh","ixl","wqmwehunbuzfh","lemdqgqwumegvfexckxgiadwlc","kcudnbvfugbntkdgjst","vgirdgjs","qdowgpmdjcowe","riwisyimddyguitvtdw","omqndxpxevx","jeqxn","x","z","mnexyhlutclb","uvdfwryvvugthazsfqu","yfxsvg","cxtoslemgfyjfz","vgirdgj","dd","hzzpjoossvz","bqwk","qdowgpmdjcowemkacwzoxukg","hklbpjmcedqcw","uvdf","yizs","kcudnbvfug","fuk","tpktncgausglce","qdowgpmdjcow","volzppbtszdnoocqy","uiuwyorgmes","nzwwarlivff","cxtosle","tveepjwpmghv","hzzpjoo","v","omq","paqwiazmm","ncghfsccrgq","yizslwlpndzjihonftlel","s","ncghfsc","bfbhnennrn","bfbhnen","ke","zaydypcbfttmuc","y","volzppbtszdnooc","zaydypcbftt","riwisyimd","eu","gslbk","lemdqgq","yizslwl","ncghfs","asglp","hzzpjoossvzgygxhgsi","hklbpjmcedqc","riwisyimddyguitvtdwgy","hzzpjoossvzgygxhgsiyduo","paqwiaz","mnexyhlutclbwvvcgdz","japawosn","qfhgg","zay","tpktncga","yi","asg","yizslwlpndzj","bqwkb","nzww","erkufypwn","itcudluaycsspjroh","tveepjwpmghvi","wve","xa","ov","eurmricmwbu","gkxzjue","cxto","yfxsvga","tpktncgausglc","zayd","mnexyhlutclbwvvc","uvdfwryvvugtha","riw","tpktn","japawosnoiobnrf","eurmricmw","hklbpjmc","kcudnbvfugbntk","asglpcpgctpdcehwt","yizslwlpndzjihonftl","hkl","erkufy","hzzpjoossvzgygxhgsiydu","yfxsvgar","paqwiazmmvgudlyu","mo","zfzpuxghsf","asglpcp","tpktncg","omqndxpxevxojfwsm","momqx","sqmhtpcgd","zfzpuxghsfmeq","qdowgpmdjcowemkacwzox","tpktncgausglcel","zaydypcbf","hklbpjmcedq","lemdqgqwumegvfe","w","u","lemdqgqwumegv","hzzpjoossvzgyg","zaydypcbft","sqmhtpcgdsdfq","hklbpj","ui","wqmwehunbuz","wqmw","hzzpjoos","qdowgp","om","yizslw","xtwmnupebcuzb","qfhggvatefv","itcu","mnexyhlutc","fu","ixlfvbvdzwnd","lemdqgqwumegvfex","qdowgpmdj","cxtosl","cxtoslemgfyj","hklbpjmcedqcwnbuowt","kcudnbvfugbntkd","qfhggvatefvw","qdowg","wqmwehunbu","sqm","zfzpux","tveepjwpm","zfzpuxghsfmeqb","gkxzjueyo","tpktncgausglceln","yizslwlpndzjih","uvdfwryvvugt","qdowgpmdjco","xtwmnupebcuzbgn","volzppbtsz","erkufypwnuhd","bfbhnennr","uiuwyo","riwisyimddyguitv","ixlfvbvdzwn","paqwiazmmvgud","tveepjwpmghviayytpa","qfhggvatefvwmqbxtdn","itcudluaycsspjro","kcudnbv","itcud","qdowgpmdjcowemkac","uvdfwryvvugth","tveepjwpmghviayytp","qdowgpmdjcowemkacwzoxuk","nzwwar","keizhk","ctgux","lemdqgqwumegvfexckx","nzwwarlivffio","rj","cxtoslemg","omqndxpxe","xtwmnup","zaydypcbfttmu","hzzpjoossvzgygxhgsiyduodp","gslbknctq","bfbhne","tveepjw","hklbpjmced","ixlfvbvdzw","mnexyh","paqwiazmmvgudlyuw","erkufypwnuh","volzppbtszdnoocq","tveepj","tpktncgaus","lemdqgqwumegvfexckxgia","uiuwyorgme","erkufypw","uiuwyorgm","eurmric","itcudluaycsspj","tve","zfzpuxghsfm","erk","hklbpjmcedqcwnbuowtt","ixlfvbvdz","hzz","ah","ncghfsccr","yizslwlpndzjihonft","volzppbtszdn","wq","cxtoslemgfy","dk","eurmri","nzwwarl","itcudluaycsspjrohfrniw","japawosnoiobnrfjrs","keizh","ncghfscc","ncgh","uiu","aqf","qfhggv","mnexyhlutclbw","gkxzjueyof","mnexyhlutclbwvvcg","tveepjwpmghvia","lemdqgqwume","asglpcpgct","hklbpjmcedqcwnb","qdow","cxtoslemgfyjf","nzwwarliv","qdowgpmdjcowemk","qfhggvatef","cxtoslemgf","japawosnoiobnrfjrsbrcuz","qdowgpm","kcudn","uvdfwryvvug","mnexyhlu","ixlfvbvdzwndv","riwisyimddyguitvtdwg","uvdfwryvv","keiz","qfhggvatefvwmqbxtdnbo","f","wqmwehu","riwisyimddyguitvtdwgyzuimf","mnexyhlutclbwvvcgdzecsuv","pa","hklbpjmcedqcwnbu","sqmhtp","hklb","omqndxpxev","mnexyhlutclbwvvcgdzecsuvf","gkxz","a","xtwmnupebc","bqwkbpq","volzpp","sqmhtpcgdsdfqgxsjgqizl","qdowgpmdjcowemkacwzoxu","fukw","sqmhtpcgdsdfqgxsjgq","uvdfwryv","sqmhtpcgdsdfqgxsjg","momqxnldh","hzzpj","itcudl","uvdfwryvvugthazsfqukai","omqndxpxevxojf","tveepjwpmghviayyt"}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String longestWord(String[] words) {
        sort(words, 0, words.length - 1);
        String result = null;

        List<String> check = Arrays.asList(words);

        for (int i = words.length - 1; i >= 0; i--) {
            if (result != null && check.get(i).length() < result.length()) {
                break;
            }

            boolean success = true;
            for (int j = 1; j <= check.get(i).length() - 1; j++) {
                if (!check.contains(check.get(i).substring(0, j))) {
                    success = false;
                    break;
                }
            }

            if (success) {
                if (result == null) {
                    result = check.get(i);
                } else if (result.length() <= check.get(i).length()) {
                    result = check.get(i);
                }
            }
        }

        return result;
    }

    private static void sort(String[] strings, int start, int end) {
        if (start >= end) {
            return;
        }

        String t = strings[start];
        int i = start, j = end;
        while (j != i) {

            while (j > i && (compare(strings[j], t) || t.equals(strings[j])) ) {
                j--;
            }

            while (j > i && (compare(t, strings[i]) || t.equals(strings[i])) ) {
                i++;
            }

            if (i < j) {
                String temp = strings[j];
                strings[j] = strings[i];
                strings[i] = temp;
            }
        }

        String temp = strings[start];
        strings[start] = strings[i];
        strings[i] = temp;


        sort(strings, start, i - 1);
        sort(strings, i + 1, end);
    }

    private static boolean compare(String a, String b) {
        if (a.length() < b.length()) {
            return false;
        }

        if (a.length() > b.length()) {
            return true;
        }

        return a.compareTo(b) > 0;
    }

}
