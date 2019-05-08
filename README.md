# LeetCode 解题笔记

项目环境：
```
IntelliJ IDEA 2018.2.8 (Community Edition)
Build #IC-182.5262.2, built on March 28, 2019
JRE: 1.8.0_152-release-1248-b22 x86_64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
macOS 10.14.4
```

### [21. Merge Two Sorted Lists](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MergeTwoSortedLists.java)
合并两个有序链表。
首先判断两个链表的头哪个小，哪个小以哪个开头，记下这个头节点，并把这个小的链表后移一位
开始循环比较，哪个链表的头小就把哪个的头接在要构造的链表屁股上，把这个小的链表往后移动一位，直到有一个链表的next == null
最后判断哪个不为空(有可能一个为空，有可能两个都为空，但不可能都不为空)，继续把这个不为空的链表全部接在要构造的链表屁股上，返回之前记录的头节点
### [387. First Unique Character in a String](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ReverseString.java)
笨办法：
先创建一个记录所有字母的数组，并赋值为-1
遍历这个数组，如果这个字符没有出现过，就在记录数组里记录他的位置；
如果出现过，就记录出现次数，最后遍历一下就行了。

聪明办法：
遍历a-z(注意不是遍历字符串)判断indexOf和lastIndexOf是不是相同的，如果是，说明它只出现了一次（indexOf返回第一次出现的位置，lastIndexOf返回最后一次出现的位置）跟目前最小的位置比较记录。最后返回。
### [344. Reverse String](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ReverseString.java)
使用一个While循环，左右往里递进调换位置就行了,没啥好说的
### [36. Valid Sudoku](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ValidParentheses.java)
判断一个数独是不是有效的，要求是

1. 数字 1-9 在每一行只能出现一次。
2. 数字 1-9 在每一列只能出现一次。
3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

其实也就是按照这三条规则检查一遍，看看每行每列每个方块是不是有重复的地方（暴力搜解方法好！）

这次我学习的重点是判断一个数列是否有重复的数据，
```
int mask = (1 << board[i][j]);
if ( (row & mask) != 0)
    return false;
else
    row |= mask;
```
先取一个数用1去左移动char个位置，记录这一位被置为1，然后用这一个只有这一位为1其他全为0的数去与之前的数；
如果不为0，说明之前的数这一位也不为0（两个相同的1才不为0），返回错误；
如果为0，用或来记录这一位出现过的数；

这里涉及到了另一个问题：int类型左移位数超过32位的问题，比如1左移50位结果是什么
int类型的数据占4个字节，一共32位，所以最多左移31位，那么后面的50如何处理呢
测试结果：1<<50 = 1<<18
50跟18相差了32，有人可能猜到了跟int类型占32位有关，也确实如此
根据java规范中描述 int a<<b, b这个操作数只能取二进制数的低五位（就是最后5位）
50的二进制表示00…00 000110010 后五位 10010就是18
b操作数取后五位，也可以理解成 b/32 取余数
所以 int a << b 可以理解成 int a << (b%32)

这个方法非常精妙（反正我是没想到）不过局限性在于只能判断不超过32个数，不然没这么多位供判断
### [20.Valid Parentheses](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ValidParentheses.java)
括号匹配问题，最简单的使用栈来解决的问题。
建立一个栈，开始遍历数据；
如果读到的数据是左括号，则直接入栈；
如果是右括号，则peek当前栈，如果弹出的与之匹配的左括号，则弹出当前peek的字符；如果不是，直接报错「因为不可能出现 '{(}' 这样的正确序列」
其他数据不管，继续遍历（本题没有其他数据，正常的括号中间有一些运算符不用检查）
### [283. Move Zeroes](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MoveZeroes.java)

查到每一个0和非0的位置，调换他们的位置。

### [66. Plus One](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/PlusOne.java)
从最后一位+1，对10取余数看是否有进位，有进位就对下一位+1。最后检查一下最后一位进位是不是1，是1就在前面+1。

本质上是在模仿进位加法。
### [217. Contains Duplicate](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ContainsDuplicate.java)
使用一个Set，每次存的时候看一下是否contains，有的话就返回false

### [122.Best Time to Buy and Sell Stock II](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/BestTimeToBuyAndSellStockII.java)

给一组股票的数据代表每天的价格，要求倒买倒卖使差价最大。

先假装持有第一个的股票，然后向后遍历。
假如后面的某一天比当前的价格便宜，假装没买过之前的，持有便宜的那天的股价；
假如后面的某一天比当前的股价贵，说明有的赚，差价就是收益，然后持有后一天的股价，继续向后遍历；
一次遍历就结束了。
### [26. Remove Duplicates from Sorted Array](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/RemoveDuplicatesFromSortedArray.java)
计算一个排好序的数组里有多少不重复的数据，并把它们移动到原数组的前面。
使用两个指针，一个A指针指向当前不重复的数据，一个B指针指向后面查找的位置。
A从首位开始查，如果下一位小于(小于是因为后面调位置出现的)等于当前位置，就开始移动B指针找到下一个大于A指针指向的数，然后移动到A指针的下一位，A指针后移一位，继续查找，直到B指针查到最后一位为止。
### [350. Intersection of Two Arrays II](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/IntersectionOfTwoArraysII.java)
给定两个数组，计算它们的交集。

使用哈希表，先遍历第一个数组，存下每一个元素出现的次数，然后看第二个数组，如果次数>0，就存到最后的结果里并且把次数-1。

### [189. Rotate Array](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/RotateArray.java)
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
这个题要求使用空间复杂度为 O(1) 的原地算法，不然可以再开辟一个相同的数组然后找对应为止放置就行。
- 方法1
模拟移动，每次向由移动1位，总共移动k次，就是时间有点长。
- 方法2
观察最后结果和原数组
```
1 2 3 4 5 6 7
5 6 7|1 2 3 4
```
在我用分割线分开的地方，分别是之前数组的前部分和后部分。把左右部分分别反转得到
```
7 6 5|4 3 2 1
```
就是原数组的反转，所以得到方法，反转三次即可
- 第一次反转：反转整个数组
- 第二次反转：反转整个数组的前部分
- 第三次反转：反转整个数组的后部分

### [136. Single Number](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SingleNumber.java)
只出现一次的数字，解法非常巧妙，使用的是位运算：异或，两个相同的数异或是0，故可以一只异或下去，最后的结果就是单独的那个数。

非常经典的位运算，见过多次了。
### [88. Merge Sorted Array](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MergeSortedArray.java)
极度偷懒如我：直接把两个数组接在一起然后...`Arrays.sort(nums)`

正经的 Merge 方法，当然是需要 Merge 一下，这道题不许开辟新的空间，复用第一个数组且空间够用，所以直接考虑倒着插入（这样第一个数组的前面部分不会被打乱）

每次比较一下，倒着插入就可以了，总之一句话：
```
nums1[index --] = i >= 0 && nums1[i] > nums2[j]?nums1[i --]:nums2[j--];
```
### [240. Search a 2D Matrix II](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SearchA2DMatrixII.java)
写一个高效的算法，从一个 m × n 的整数矩阵中查找出给定的值，矩阵具有如下特点：
- 每一行从左到右递增。
- 每一列从上到下递增。

我一开始想用的是递归直接搜，广度优先，结果大数据直接超时了。不行换思路。

考虑到这个数像一个夹心饼干一样被夹在数据中，故可以使用二分查找发来查，先确定数据所在的行，遍历每一行，如果行首大于目标或者行尾小于目标，就移动行的上下限，最后在有限的行内使用二分查找法，这样是可以过的。

看大神写的代码，从矩阵的右上角开始查（理论上从左下角开始也是可以的），如果查找游标比目标大则向内（左侧）移动，如果查找游标比目标小则向外（下侧）移动，直到移出或者找到为止，时间空间复杂度都是最优，学习一下
### [13. Roman to Integer](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/Roman2Integer.java)
先把所有的罗马数字按照量级存起来，然后遍历这个字符串，10、100、1000这样的字符可以归为一类。然后不断取出字符串、累加就可以了
### [9. Palindrome Number](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/PalindromeNumber.java)
使用递归可以使代码看起来简洁（其实用 while 循环也可以...）
先判断是不是负数，负数不是回文。然后每次取最后一位和第一位，判断是否相等，相等截取中间的字符继续判断，位数小于2为止。
注意每次取余数之类的可能会有 float ，要转成 int
### [3. Longest Substring Without Repeating Characters](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/LongestSubstringWithoutRepeatingCharacters.java)
求一个字符串最长非重复子串，思考一下，两个最近重复的字符中间的字符就是非重复的字串。
使用哈希表的思想，遍历每一个字符及其后面的字符串，使用一个char[128]的数组记录每个字符出现的的位置，如果这个字符在后面又出现过了，说明找到了以这个字符为首的最长子串，遍历完就找到了最长的那个。
遍历的时候，如索引后面剩余的子串都不如目前的大，则不用再检查了，直接返回最大的就行了
### [7. Reverse Integer](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ReverseInteger.java)
反转一个带符号的整数。
先判断这个数是不是负数，保存符号位，然后循环对10取余，再反向乘以10加起来，带上符号位返回。
注意 Int.MAX_VALUE 和 Int.MIN_VALUE 的判断
### [1. Two Sum](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/TwoSum.java)
最直观的思路就是用两层循环，外层循环遍历数组，内层去遍历它之前的数组，加一起等于target的就返回，不过这样时间复杂度是 O(n*n)

换成使用HashMap,每次保存当前数值和索引，存入下一个数值之前先检查Map里否有与当前数值相加为 target 的数，有的话直接返回，没有则存入继续下次搜索。
### [827. Making A Large Island](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MakingALargeIsland.java)
这道题使用了并查集的知识，将所有岛先进行一次并查集操作，转化成只有两级的以代表元为根的树形结构，记录每个岛的父节点，在另一个数组中存储这个“合并岛”的大小。然后遍历为0的岛，判断是否有相邻为1的岛并去查找其父节点，找到父节点之后去查找该父节点的“合并岛”的大小（注意去重，有可能相邻的岛查到了形同的父节点），找到四个相邻岛加起来就是该为0的岛的结果，找到最大的结果即可。
### [513. Find Bottom Left Tree Value](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/FindBottomLeftTreeValue.java)
这道题要求找到二叉树最下面一排的第一个元素，思路就是每次遍历一层二叉树，并在遍历的时候记录第一个元素，全部遍历完，记录的那个元素就是结果。这里使用队列来进行二叉树的遍历，我使用 Java 中的 LinkedList 当作队列来使用，遇到的一个坑就是向队列队尾添加元素应该使用 offer 而不是使用 push ，**push 在队列里是向队首添加元素的意思！**,
* poll 队首弹出
* offer 添加队尾
* element 预览

### [79. Word Search](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/WordSearch.java)
这道题是使用递归，同时传入所需子串和当前搜索位置，搜索完字符串则成功。需要注意的每一个位置只能使用一次，所以需要一个数组记录访问过的位置。
### [48. Rotate Image](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/RotateImage.java)
这道题是旋转一个数组，观察之后发现旋转是一环一环进行的，外圈怎么旋转也不会到内圈去（有点像玩魔方，角块怎么转也不会去边上），故使用递归一圈一圈旋转。

对于一圈一圈转的时候，是四条边互相交换位置，所以遍历一条边上的数，对于一条边上的某个值，作四次对换就OK了，就是确定四个值的位置时需要小心一些，算好就可以了。
### [803. Bricks Falling When Hit](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/BricksFallingWhenHit.java)
打砖块，如果没有和顶部相连的砖块就算作掉下来，此题通过逆向思维，先将所有的砖块打落，然后通过深度优先计算与顶部相连的砖块，是击落最后一块砖之后的结果，然后倒着加砖块，每加一块砖，重新计算一次与顶部相连的砖块，计算完成之后的数量减去上一只与顶部相连的砖块的值即是本次击落的砖块。
### [147. Insertion Sort List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/InsertionSortList.java)
通过两次遍历来插入链表，
- 第一层遍历：遍历需要比较的节点，每次记录当前比较的节点、已排好序的链表的头节点、还未比较链表的头节点。
- 第二层遍历：将当前比较的节点一次与已排好序的链表进行比较，找到合适位置插入，注意如果是最大🔥最小的情况处理。
注意将每次当前比较的节点的后驱置为 null ，不然会造成链表循环。

### [164. Maximum Gap](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MaximumGap.java)
要求找到排序之后的相差最大的两个值，这个题要求空间时间复杂度都是线性的，其实是考排序算法的。
~~偷鸡法：Arrays.sort(nums)~~
要求时间空间复杂度是线形的，这里使用基数排序来实现.

### [523. Continuous Subarray Sum](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ContinuousSubarraySum.java)
这道题是要求找出是否有相邻的几个数的和正好是给定数据的倍数，思路是线性相加，每次对给定倍数取余数，并放到字典里，下次相加是如果字典里有这个余数，说明存在这样的数，用到了下面的原理：

> 如果给定 ...i...j...k... 的数据的序列，如果 sum(0,j) % divisor = m 且 sum(0,k) % divisor = m ,那么 [sum(j, k) - m] % divisor = 0;

想法很好，但是做起来有很多坑，如
* 连续相邻的两个 0 是所有数的倍数
* 只有一个除数不算，要多于一个数才行

### [264. Ugly Number II](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/UglyNumberII.java)
我们现在已经有了一个丑数的有序数组，如果要找到下一个丑数，则可以将数组中的每一个数乘以2，并将其中第一个大于当前丑数的的结果记为M2，同样将当前有序数组每一个数都乘以3，第一个大于当前丑数的的结果记为M3，同样方式得到乘以5的第一个大于当前丑数的结果记为M5。可以下一个丑数必然是min(M2, M3, M5)。

不必要将数组中的每个数都乘以2,3,5。对于乘以2来说，我们只要找到第一个乘以2大于当前丑数的数在数组中的位置，同样找到第一个乘以3,5大于当前丑数的数的位置。如果当前丑数记为M，然后就可以使用min(M*2, M*3, M*5)来产生下一个丑数。

### [313. Super Ugly Number](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SuperUglyNumber.java)
本质上和 264. Ugly Number II 没有什么区别。
### [767. Reorganize String](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ReorganizeString.java)
重排字符串，要求是不能有两个相同的字符串，如果有相同的返回空的。

先判断能不能排序，方法是归纳一下，如果最多的那个字符超过了字符串的长度，就不能。

然后把所有的字符按照出现频率从大到小的顺序排列一下，在偶数位置依次摆放，一个多的字符放完了就放次多的，偶数位置放完了就放奇数位置。
### [885. Spiral Matrix III](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SpiralMatrixIII.java)
给一个矩形和一个指定的位置，围绕着指定位置一圈一圈的打印这个矩形。

我的思路是按照这个指定位置造一个回形的矩形，然后找到原来的矩形相对于新矩形的相对位置，一圈一圈的在新矩形上打印，每次打印之前，把新坐标点换算到老矩形当中看看是否合法，不合法则跳过，一圈一圈打印完就可以了。
### [56. Merge Intervals](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MergeIntervals.java)
合并重复的线段。

先把线段按照首位大小排序，然后持有一个，开始遍历：
- 如果下一个的首位比这一个的末尾小，说明有重叠，把他们合并成一个线段，这里注意，**合并后的线段的末端是这两个重叠线段较大的那个数，不能认为是第二个线段的末端**，然后继续持有这个合并后的线段，继续遍历
- 如果下一个的首位比这一个的末尾大，说明没有重叠，直接存这个持有线段，然后持有下一个线段，继续遍历

最后别忘了把最后持有的这个线段也存入结果，最后返回结果即可。
### [593. Valid Square](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ValidSquare.java)
做的很麻烦。。。先把四个点排列组合，只要有一个组合行就可以。

总共要判断四个条件：
- 对角线相等：平方和相等
- 对角线垂直
- 对边平行
- 对边相等：平方和相等

如果有两个向量(x1,y1),(x2,y2)
- 平行：x1 * y1 == x2 * y2
- 垂直：x1 * y1 + x2 * y2 == 0

### [166. Fraction to Recurring Decimal](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/FractionToRecurringDecimal.java)

分数转小数的除法运算，很简单，就是用小学时学过的"厂"除法辗转着除就行了，每次把余数记下来，下次再除出余数的时候，先看是不是已经有过了，有过的话就把上一次这个余数出现的位置到目前最后一位全都循环起来就行了，不过边界条件巨多。

1. 被除数是0的时候，直接为0
2. int 型转成 long 型，补零的时候有可能位数不够
3. 除数和被除数都是负数的时候，要先给转成正数
4. 除数和被除数有一个是负数的时候，要先给转成正数，然后给最后的结果填一个负号
5. 被除数比除数大，最后结果有整数部分
6. 直接整除了，返回一个整数
7. 到此为止，开始小数除法部分，开始给被除数补零，结果加小数点，余数进数组
8. 余数让除数整除了，返回一个整除结果
9. 除数比余数数大，给余数补零，结果也补零，判断是余数是否存在
10. 除数比余数数小，除一下得到新的余数，判断是余数是否存在
