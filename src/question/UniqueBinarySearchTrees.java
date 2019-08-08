package question;

/**
 * question
 * LeetCode
 * 2019.08.08.11:41
 * <p>
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * @author : artairs
 */
class UniqueBinarySearchTrees {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(numTrees2(3));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    /**
     * 算法思路，选取这一串有序数据中的一个作为根节点，则比它大的均为其右子树，比它小的均为其左子树，则选取这个节点的情况种数为 catalan[i] * catalan[n - i - 1]
     * 所以依次选取每个节点作为根节点再将没中情况相加就得到了最后的结果
     * 状态转移方程 ：把 n = 0 时赋为1，因为空树也算一种二叉搜索树，那么 n = 1 时的情况可以看做是其左子树个数乘以右子树的个数，
     * 左右子树都是空树，所以1乘1还是1。那么 n = 2 时，由于1和2都可以为根，分别算出来，再把它们加起来即可。
     * catalan[2] = catalan[0]*catalan[1] + catalan[1]*catalan[0]
     * catalan[3] = catalan[0]*catalan[2] + catalan[1]*catalan[1] + catalan[2]*catalan[0]
     * catalan[n] = for(i:0 -> n-1){ catalan[i] * catalan[n - i - 1] }
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = 1;

        for (int i = 1; i < catalan.length; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }

    /**
     * catalan[n] = C(n,2n)/n-1
     *
     * @param n
     * @return
     */
    public static int numTrees2(int n) {
        long res = 1;
        for (int i = n + 1; i <= 2 * n; ++i) {
            res = res * i / (i - n);
        }
        return (int) (res / (n + 1));
    }


}
