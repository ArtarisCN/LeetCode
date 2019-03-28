# LeetCode 解题笔记

### 827. Making A Large Island

这道题使用了并查集的知识，将所有岛先进行一次并查集操作，转化成只有两级的以代表元为根的树形结构，记录每个岛的父节点，在另一个数组中存储这个“合并岛”的大小。然后遍历为0的岛，判断是否有相邻为1的岛并去查找其父节点，找到父节点之后去查找该父节点的“合并岛”的大小（注意去重，有可能相邻的岛查到了形同的父节点），找到四个相邻岛加起来就是该为0的岛的结果，找到最大的结果即可。

### 513. Find Bottom Left Tree Value

这道题要求找到二叉树最下面一排的第一个元素，思路就是每次遍历一层二叉树，并在遍历的时候记录第一个元素，全部遍历完，记录的那个元素就是结果。这里使用队列来进行二叉树的遍历，我使用 Java 中的 LinkedList 当作队列来使用，遇到的一个坑就是向队列队尾添加元素应该使用 offer 而不是使用 push ，**push 在队列里是向队首添加元素的意思！**,
* poll 队首弹出
* offer 添加队尾
* element 预览

### 79. Word Search

这道题是使用递归，同时传入所需子串和当前搜索位置，搜索完字符串则成功。需要注意的每一个位置只能使用一次，所以需要一个数组记录访问过的位置。

### 48. Rotate Image

这道题是旋转一个数组，观察之后发现旋转是一环一环进行的，外圈怎么旋转也不会到内圈去（有点像玩魔方，角块怎么转也不会去边上），故使用递归一圈一圈旋转。

对于一圈一圈转的时候，是四条边互相交换位置，所以遍历一条边上的数，对于一条边上的某个值，作四次对换就OK了，就是确定四个值的位置时需要小心一些，算好就可以了。

### 803. Bricks Falling When Hit

打砖块，如果没有和顶部相连的砖块就算作掉下来，此题通过逆向思维，先将所有的砖块打落，然后通过深度优先计算与顶部相连的砖块，是击落最后一块砖之后的结果，然后倒着加砖块，每加一块砖，重新计算一次与顶部相连的砖块，计算完成之后的数量减去上一只与顶部相连的砖块的值即是本次击落的砖块。

### 147. Insertion Sort List

通过两次遍历来插入链表，
- 第一层遍历：遍历需要比较的节点，每次记录当前比较的节点、已排好序的链表的头节点、还未比较链表的头节点。
- 第二层遍历：将当前比较的节点一次与已排好序的链表进行比较，找到合适位置插入，注意如果是最大🔥最小的情况处理。
注意将每次当前比较的节点的后驱置为 null ，不然会造成链表循环。

### 164. Maximum Gap

要求找到排序之后的相差最大的两个值，这个题要求空间时间复杂度都是线性的，其实是考排序算法的。
~~偷鸡法：Arrays.sort(nums)~~
要求时间空间复杂度是线形的，这里使用基数排序来实现。

### 523. Continuous Subarray Sum

这道题是要求找出是否有相邻的几个数的和正好是给定数据的倍数，思路是线形相加，每次对给定倍数取余数，并放到字典里，下次相加是如果字典里有这个余数，说明存在这样的数，用到了下面的原理：

> 如果给定 ...i...j...k... 的数据的序列，如果 sum(0,j) % divisor = m 且 sum(0,k) % divisor = m ,那么 [sum(j, k) - m] % divisor = 0;

想法很好，但是做起来有很多坑，如
* 连续相邻的两个 0 是所有数的倍数
* 只有一个除数不算，要多于一个数才行

264. Ugly Number II

我们现在已经有了一个丑数的有序数组，如果要找到下一个丑数，则可以将数组中的每一个数乘以2，并将其中第一个大于当前丑数的的结果记为M2，同样将当前有序数组每一个数都乘以3，第一个大于当前丑数的的结果记为M3，同样方式得到乘以5的第一个大于当前丑数的结果记为M5。可以下一个丑数必然是min(M2, M3, M5)。

不必要将数组中的每个数都乘以2,3,5。对于乘以2来说，我们只要找到第一个乘以2大于当前丑数的数在数组中的位置，同样找到第一个乘以3,5大于当前丑数的数的位置。如果当前丑数记为M，然后就可以使用min(M*2, M*3, M*5)来产生下一个丑数。
