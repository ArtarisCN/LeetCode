# LeetCode 解题笔记

项目环境：

> IntelliJ IDEA 2018.2.8 (Community Edition)
>
> Build #IC-182.5262.2, built on March 28, 2019
>
> JRE: 1.8.0_152-release-1248-b22 x86_64
>
> JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
>
> macOS 10.14.4
>

### [112.Path Sum](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/PathSum.java)

依照题目所说，当且仅当根节点到叶子节点的路径之和才算数，所以必须找到叶子节点才行。
递归查找：
- 查到该节点为空，说明它不是叶子节点，返回false
- 查到该节点左右节点都是空，说明是叶子节点，返回「剩下的和」== 当前节点的值
- 查到该节点只有左/右子树，说明它不是叶子节点，但还有救，继续查它的左/右子树，并在查的时候用之前的和减去当前节点的值
- 查到该节点膝下双全，说明它不是叶子节点，一定有救，继续查它的左右子树，和上面一样和减去当前节点的值，并且左右子树只要有一个符合就行，所以这里用 「||」或运算

### [110. Balanced Binary Tree](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/BalancedBinaryTree.java)

判断一棵树是否是平衡二叉树：
- 左子树和右子树的高度差不能超过1：所以需要有一个计算树的高度的函数
- 左子树和右子树均为平衡二叉树：递归调用判断函数判断左右子树

### [148. Sort List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SortList.java)

对一个链表排序。
较快的排序算法有：快排、堆排、归并
因为是单向链表，快排和堆排都不太适用。这里选择归并排序。
归并排序的思想就是先拆再和，拆到只有唯一一个节点为止。这里依然适用快慢指针来寻找中点，前链表断链，递归归并来实现的。

### [25. Reverse Nodes in k-Group](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ReverseNodesInKGroup.java)
按照K组反转链表，是之前反转链表的变体，使用两层循环，一层走总的，另一层，一组一组的反转。
需要注意的点
- 虚拟头节点！虚拟头节点！虚拟头节点！有一个虚拟头节点判断起来简单的多
- 每次反转一组之前先使用一个步骤找到这次需要反转的首尾，然后开始反转
- 反转的时候需要记录前一组的最后一个，后一组的第一个
- 反转完毕以后把这一组的第一个当成之后下一组的第一个「因为已经反转了，刚才这一组的第一个已经变成最后一个了」，继续反转下一组
- 如果记录当前链表的个数不足所给组的个数，不反转直接返回
- 反转链表请看[206. Reverse Linked List](https://github.com/ArtarisCN/LeetCode#206-reverse-linked-list)

### [109. Convert Sorted List to Binary Search Tree](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ConvertSortedList2BinarySearchTree.java)

和 [108. Convert Sorted Array to Binary Search Tree](https://github.com/ArtarisCN/LeetCode#108-convert-sorted-array-to-binary-search-tree)很像，思路是使用快慢指针来寻找链表的中点，然后把中点当根节点，前面的断链，作为左子树，后面的作为右子树，递归造树就行了。
### [108. Convert Sorted Array to Binary Search Tree](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ConvertSortedArrayToBinarySearchTree.java)
搜索树
- 当前节点都比左子树大，都比右子树的小；
- 搜索树的子树还是搜索树；

将一个排序数组转成搜索树，因为是排好序的，所以中间的的那个值就是根节点。
然后根节点左边的所有值就是他的左子树，依然是个搜索树。
这里就可以用到递归继续递归左边半个数组继续生成他的左子树，右子树同理。
注意处理一下当数组个数不小于三的情况。

### [104. Maximum Depth of Binary Tree](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MaximumDepthOfBinaryTree.java)

依然递归查找，设置一个带当前节点深度的递归函数，然后返回Max(左子树.当前深度 + 1 ,右子树.当前深度 + 1)
当然如果当前节点不存在，然后返回 - 1 就行了。

### [101. Symmetric Tree](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SymmetricTree.java)

判断两颗树是否是对称的。
对称的标准是：
* 你有(子树)我也有(子树)；
* 你没有我也没有；
* 我和你(根节点)相等；
* 我的左和你的右对称；
* 我的右和你的左对称；
把握好这几个条件，递归的找到所有该对称的子树就行了

### [100. Same Tree](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SameTree.java)

两棵树相等的情况是左子树完全等于右子树，所以递归的判断就好。
`p.left == q.left &&  p.right == q.right  &&  p.root == q.root`
当递归到叶子节点的递归结束

### [83. Remove Duplicates from Sorted List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/RemoveDuplicatesFromSortedList.java)

依序遍历链表
- 如果当前的值比前一个值大，则替换上一个值；
- 如果当前值等于前一个值，则把当前节点从链表踢掉；

### [111. Minimum Depth of Binary Tree](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MinimumDepthOfBinaryTree.java)

利用递归查找小深度，注意的就是每个深度要+1「根节点的度」

### [445. Add Two Numbers II](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/AddTwoNumbersII.java)

正向累加两个链表，我用了个栈，轻轻松松就完成了任务，并且没有使用题目中说的逆向反转链表，呵呵。「其实本质差不多」

### [237. Delete Node in a Linked List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/DeleteNodeInALinkedList.java)

开始我没理解，只给一个节点怎么删除，又不知道前驱，没法指向要被删的后一个节点。
看了解析就是把后面的值赋给要被删的节点，然后把它后一个节点删了「后一个节点：我做错了什么」坑爹呀～
掌握一种思路：可以更改赋值而不是对节点这个对象处理。

### [82. Remove Duplicates from Sorted List II](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/RemoveDuplicatesFromSortedListII.java)
删除链表中的重复节点，一旦有重复的就全部删除，这个题的关键点是设立一个虚拟头节点。有了虚拟头节点处理起来方便很多。
### [143. Reorder List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ReorderList.java)

重排链表，具体什么规则看看原题，我的思路是先找到中间节点，断链，把后部分链表反转，然后你一我一的重新串起来。边界条件都写在代码里了。

* 找到中间节点：快慢指针
* 链表反转：[206. Reverse Linked List](https://github.com/ArtarisCN/LeetCode#206-reverse-linked-list)

### [61. Rotate List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/RotateList.java)
旋转链表，这个题有点技巧，首先记一次链表的长度，并用所给的 K 对 链表长度取余，如果余数等于0，直接返回原 head，这样就保证了旋转的数一定在链表长度之内。

使用两个指针，一个指向头节点，另一个指向距离头节点 K + 1 的位置，然后两个指针同时向后移动，直到第二个节点为空为止，这时第一个节点指向的就是要断链的位置，同时移动的时候别忘了记录一下，第二个节点的前一个节点，最后也就是整个链表的末节点。

然后断链，第一个节点的下一个节点为新的头节点，末节点指向之前的头节点，第一个节点的下一个为空，就完成了旋转
### [24. Swap Nodes in Pairs](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/SwapNodesInPairs.java)
两两交换节点，首先设立一个虚拟头节点会让处理头节点的时候非常简单，然后就是设置三个节点，两个是要交换的节点，另一个是他们之前的那个节点。
交换了以后把这三个节点都向后推，然后一直循环到结束就行了，最后把虚拟头节点的next返回回去。
### [328. Odd Even Linked List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/OddEvenLinkedList.java)
同样是一道「穿针引线」的题。
使用两个节点，遍历一次链表，奇数位的接在第一个节点之后，偶数位接在第二个节点之后。最后把这两个节点串起来。

别忘了在偶数头节点不为空「只有一个节点传进来的时候」设置偶数末尾节点的 next = null
### [86. Partition List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/PartitionList.java)
对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
使用两个节点，遍历一次链表，小于给定数据的接在第一个节点之后，否则接在第二个节点之后。最后把这两个节点串起来。想通了还是挺简单的，最开始我想用两个节点判断大小然后交换，想歪了。
### [198. House Robber](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/HouseRobber.java)
抢劫，从末尾往前看，每一间房子只有抢和不抢两种选项。如果抢了 x 号房间，则不能抢x - 1 号房间，则状态转移方程为：

```
maxRobValue[n] = max(maxRobValue[n - 1],maxRobValue[n - 2] + value[n])
```

依照状态转移方程自底向上或者递归都可以解决

### [62. Unique Paths](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/UniquePaths.java)
构建从左上角到右下角的所有路径，倒着递推，每个格子的路径数等于左边格子的路径数加上面格子的路径数，则状态转移方程为：

```
result(n, n) = result(n - 1, n) +result(n, n -1)
```

计算的时候注意边界条件判断就行了


### [63. Unique Paths II](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/UniquePathsII.java)
和上面的那道题类似，多了一个障碍物。状态转移方程和上面类似，多了两个判断：
* 左上角和右下角不能是障碍物
* 如果一个格子的左边或者右边是障碍物，不计数

### [91. Decode Ways](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/DecodeWays.java)
也是一道动态规划的问题，逆推，一个数的分解可以减去两个数或者一个数，则状态转移方程为：

```
result(n) = result(n - 1) +result(n - 2)
```

不过这两个数不一定都合法，
- 剪掉的一位数必须在1 - 9为合法
- 剪掉的一位数必须在10 - 26为合法

计算次数的时候加一下判断

### [141. Linked List Cycle](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/LinkedListCycle.java)
快慢指针的思路求解是否有环形链表的方法。
设置两个指针，一个每次走一步，一个每次走两步，如果存在环形链表，那么这两个指针的结果都是在环上绕圈子。快指针一定会在这个圈子上追上慢指针，也注定不会错过一定会有这两个指针相等的时候。
### [16. 3Sum Closest](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ThreeSumClosest.java)
我的解法基本和[15. 3Sum](https://github.com/ArtarisCN/LeetCode#15-3sum)类似。只是多使用了一个变量来计算差值，每次比较的是当前差值和之前的差值的大小。
### [69. Sqrt(x)](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/Sqrt_x_.java)
看似二分查找法，使用趋紧的方式来查找，从 `x/2 + 1` 至 0 开始找，小了就缩左边界，大了就缩右边界。
要注意的是
1. 如果左右两个边界差值为1 的时候就可以返回了，以免陷入死循环（因为取中间值每次都不会再缩小边界了）
2. 最后应该返回左边界，因为题目要求的答案是向下取整

**数学方法**

[牛顿逼近法](https://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html)了解一下
### [279. Perfect Squares](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/PerfectSquares.java)
动态规划问题，思路如下：
如果一个数已经是完美平方数，则他的分解情况是1；
如果一个数不是完美平方数，则找到他能开的最大完美平方数「如12能开的最大完美平方数是9，既3」
使用一个数组记录每个数的完美平方数的分解情况，自底向上计算，如果一个数属于情况一，直接把分解情况写为1，如果属于情况二，就遍历一遍找到最大的完美平方数的所有分解情况，找到最小的值即可。

### [206. Reverse Linked List](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ReverseLinkedList.java)

一道考验链表微操的题，每次需要记录三个点，当前节点，当前节点的前一个节点，当前节点的后一个节点。
每次重新串的顺序是：
- 先记录一下当前节点的后一个节点
- 当前节点的next = 当前节点的前一个节点
- 当前节点的前一个节点 = 当前节点
- 当前节点的后一个节点 = 当前节点的后一个节点.next
- 当前节点 = 当前节点的后一个节点

### [343. Integer Break](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/IntegerBreak.java)
还是动态规划的题目（其实并不是T_T）
**先说动态规划的方法：用 Break(n) 代表 n 的最大分解。**
若求 Break(n) 的最大分解，则将它分解成 n - a 和 a 两个数。则 Break(n) 等于一下几个数的最大值：
1. Break(n - a) * Break(a): n - a 的最大分解乘以 a 的最大分解；
2. Break(n - a) * a: n - a 的最大分解乘以 a （a 不分解）；
3. （n - a） * Break(a): n - a 乘以 a 的最大分解（n - a 不分解）；
4. （n - a） * a: n - a 乘以 a （n - a 与 a 都不分解）；
5. 之前比较的最大值

所以求 Break(n) 就把 [1,n-1]...[n/2,n - n/2]的所有情况都考虑完就行了，注意保存缓存避免多次计算。
**再说说简单的方法**
由均值不等式(n个数的算术平均数大于等于它们的几何平均数)：

![](http://img.artaris.cn//blog/img/Jietu20190524-120525.png)

得：当把输入的n拆分成几个相等的数时它们的积最大。
那么问题来了，拆分成几个呢？
为了方便使用导数，我们先假设我们可以把n拆分成实数。那么设每一个数为x,则一共有n/x个数。
设它们的积为f(x),则f(x)=x(n/x)，那么怎么求f(x)最大值呢？求导数！
f′(x)=(n/x^2)  *  x^(n/x)  * (1-lnx)
当x=e时取极大值。
而我们题目里规定x为整数，那么我们只需要取的x越靠近e越好。那么2<e<3，而且e=2.71828...，所以取3是最好的，如果取不到3就取2。

最后知道真相的我眼泪掉下来。
### [15. 3Sum](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ThreeSum.java)
计算三个数相加为0，切不能有重复
首先想到的就是把数组排序，排好序之后固定一个数，其他两个数从这个数的右边剩余的数的两头开始取，和大了就把左边的指针往右移动，小了就把右边的指针往右移动
排好序的好处是避免了重复检查的情况，固定了第一个数得到了一组答案，随后这个数向右移动，所得到的答案的所有数，肯定都比这个数大，不会有重复的。
这里需要注意两个检查
- 第一个数固定，如果下次检查的数和上次的相等，则跳过这次检查
- 找到三个数之后，这三个数和上次的三个数都不同，才添加

因为我们的数组是排好序的，所以只用记录上次的三个数就行了，更久远就不用记录了（因为检查一限定了这次的三个数肯定比上上次的三个数要大）
### [67. Add Binary](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/AddBinary.java)
给两个字符串二进制形，对他们做加法在转成二进制输出
就是末尾对齐然后开始加，计算进位，我用的 StringBuilder 来进行相加。
### [64. Minimum Path Sum](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MinimumPathSum.java)
动态规划问题
动态规划问题想到某个点向右下角移动的路径是不受之前怎么走影响的，所以某个点的最佳路径可以根据它后面的走法确定，再根据这个点去确定前面的路径走法。
动态转移方程为：
```
result[x][y] = Math.min(grid[x][y] + result[x + 1][y], grid[x][y] + result[x][y + 1]);
```
某个点的值等于它当前点的值和右边或者下边的和取最小值，如果不知道右边或者下边的值，则先去计算右边或者下边的值，并记录下来。
其他需要注意的的就是边界条件判断。
### [120. Triangle](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/Triangle.java)
还是动态规划的问题，这题的解题方法时自上而下的寻找最佳路径。
从最多的那一层开始找，向上寻找最短路径，每个结点的最佳路径是当前的节点的值加上它左右子树的最小值，因为计算过的节点到最下层的最佳路径已经算出来了，下一层怎么到最低层不影响上面的路径变化，所有自底向上是思路的方向。
### [70. Climbing Stairs](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ClimbingStairs.java)
最简单的动态规划问题
每一节楼梯的可能性K是由它前两节楼梯实现的，比如第K(n)节的可能性等于K(n)+K(n-1)
「因为第n节楼梯只能由第 n-1 楼梯或者 n-2 楼梯完成，就是这两种情况的和」
解法有两种，自上而下或者自下而上
- 自上而下
递归的求解，欲求第 n 节必先求 n-1 和 n-2，第 n-1 节必先求 n-2 和 n-3，一层层递归下来，终止条件是0或者1
- 自下而上
已知0或者1层时的结果都是1，循环向上求解，最终得到第n层结果

这两种解法都需要一个辅助数组来记录求过的某层，因为求解第n层结果的时候会被计算多次，比如欲求第 n 节必先求 n-1 和 **n-2**层，欲求第 n-1 节必先求 **n-2** 和 n-3。这里**n-2**被计算了多次，记录可以避免多次重复计算。
### [12. Integer to Roman](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/Integer2Roman.java)
整数转罗马数字
因为罗马数字最多只有四位，我这里把每一位分类讨论的。每一位（个十百千）分别转成罗马数字再拼起来
### [11. Container With Most Water](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ContainerWithMostWater.java)
从最大的底长入手，即当容器的底等于数组的长度时，则容器的盛水量为较短边的长乘底
设定左右两个指针，分别指向左右两个极限值，由于底长已经是最大，面积主要受短边影响
每次移动短边的指针，边移动边比较总容量，最后记录即可，直到两指针相遇停止。
让人疑惑的是为什么这种算法下不会错过最佳指针地点（就是以这两个指针为左右的时候面积比其他情况都大），假设最大值的左右指针的位置是 x,y。
假设左指针先移动到x，这时右指针必然在y + a(a > 0)的位置「如果右指针在y - a 的位置说明是右指针先到最佳地点，与假设不符；如果右指针在y的位置说明没有错过最佳地点，这两个点的面积会被比较到」这时要错过只会是 x 的长度小于 y + a 的长度才会移动左指针造成错过的情况，但是这样的话 x————y 的面积一定小于 x————(y+a)的又与假设矛盾。
假设右指针先移动到y的推理过程类似，所以不会错过最佳指针地点。
### [58. Length of Last Word](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/LengthOfLastWord.java)
我先 trim 了一下去除末尾空格，
后序遍历字符串，如果遇到空格就跳出循环，边遍历边计数
### [146. LRU Cache](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/LRUCache.java)
制作一个LRU缓存，思路是制造一个双向链表。
- 查找的时候顺序查找，如果找到了，就把它提到首位来
- 插入的时候先查一下是否已经有这个key
    - 如果有，替换值并且把它放到首位来
    - 如果没有，检查是否超过限制了
        - 超过了，把最后一个尾节点断链，存入新的值，放到首位
        - 没超过，构造一个新的值来放到首位

优化的思路是使用一个 Key-Entry 的 HashMap 来存整个链表，查的时候会快很多。
### [134. Gas Station](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/GasStation.java)
这个我自己没找到最简算法，通过了但是时间空间复杂度很垃圾。
先进行一遍遍历看看总的燃料够不够总消耗，并且当前站能不能作为开始站（就是判断当前站的燃料是不是超过当前站的消耗）并记录下来。
然后就是遍历每一个开始站，加上下一站的燃料并且减去消耗，判断是不是为负，如果回到原点了，就说明可以，不然不行。
注意在数组末尾的换行。
### [21. Merge Two Sorted Lists](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/MergeTwoSortedLists.java)
合并两个有序链表。
首先判断两个链表的头哪个小，哪个小以哪个开头，记下这个头节点，并把这个小的链表后移一位
开始循环比较，哪个链表的头小就把哪个的头接在要构造的链表屁股上，把这个小的链表往后移动一位，直到有一个链表的next == null
最后判断哪个不为空(有可能一个为空，有可能两个都为空，但不可能都不为空)，继续把这个不为空的链表全部接在要构造的链表屁股上，返回之前记录的头节点
### [8. String to Integer (atoi)](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/String2Integer.java)
用了三个记录变量，一个是字符串转的char数组，一个是符号位，一个是判断是否非法的标志位。
经过一系列判断...把每一位放到一个数组里，最后经过判断是否超过了Integer.MAX_VALUE，然后返回。
这个题我觉得没啥难点，就是条件判断有点多...
### [125. Valid Palindrome](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ValidPalindrome.java)
没啥特别注意的，就是用两个指针一个在左一个在右向中间缩小判断是否一样
提前处理一下大小写的问题（我是处理了，其实也可以不处理，就是在判断的时候多一种条件就行了）
### [242. Valid Anagram](https://github.com/ArtarisCN/LeetCode/blob/master/src/question/ValidAnagram.java)
判断是否两个字符串出现过的字母一致
先判断长度是不是一样
遍历第一个字符串，用一个哈希表记录每个字符出现的次数
遍历第一个字符串，在上一个哈希表里减去出现过的字符，减成负的说明不一致
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

要求时间空间复杂度是线形的，这里使用[基数排序](https://github.com/ArtarisCN/LeetCode/blob/master/src/util/SortUtils.java)来实现.

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
