//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 二叉树 
// 👍 80 👎 0


package leetcode.editor.cn

/**
 * 1104
 * 二叉树寻路
 *
 * @author Gargantua丶
 * 2021-07-29 00:59:16
 */
class PathInZigzagLabelledBinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun pathInZigZagTree(label: Int): List<Int> {
            var l = label
            val n = kotlin.math.log(l.toDouble(), 2.0).toInt()
            if (n % 2 != 0) l = l xor ((1 shl n) - 1)
            val ans = ArrayList<Int>()
            ans.add(1)
            for (i in 1..n) {
                ans.add(l shr (n - i) xor if (i % 2 != 0) (1 shl i) - 1 else 0)
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}