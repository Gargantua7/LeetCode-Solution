//我们构建了一个包含 n 行( 索引从 1 开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。 
//
// 
// 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。 
// 
//
// 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始） 
//
// 示例 1: 
//
// 
//输入: n = 1, k = 1
//输出: 0
//解释: 第一行：0
// 
//
// 示例 2: 
//
// 
//输入: n = 2, k = 1
//输出: 0
//解释: 
//第一行: 0 
//第二行: 01
// 
//
// 示例 3: 
//
// 
//输入: n = 2, k = 2
//输出: 1
//解释:
//第一行: 0
//第二行: 01
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 30 
// 1 <= k <= 2n - 1 
// 
//
// Related Topics 位运算 递归 数学 👍 244 👎 0

package leetcode.editor.cn

/**
 * 779
 * 第K个语法符号
 * 
 * @author Gargantua丶
 * 2022-10-20 17:24:11
 */
class KThSymbolInGrammar {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun kthGrammar(n: Int, k: Int): Int {
        return Integer.bitCount(k - 1) % 2
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
