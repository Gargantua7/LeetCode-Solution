//给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：true
// 
//
// 示例 2： 
//
// 输入：10
//输出：false
// 
//
// 示例 3： 
//
// 输入：16
//输出：true
// 
//
// 示例 4： 
//
// 输入：24
//输出：false
// 
//
// 示例 5： 
//
// 输入：46
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 计数 枚举 排序 👍 49 👎 0

package leetcode.editor.cn

/**
 * 869
 * 重新排序得到 2 的幂	
 *
 * @author Gargantua丶
 * 2021-10-28 00:03:09
 */
class ReorderedPowerOf2 { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        val l = n.toString().length
        val count = IntArray(10)
        n.toString().forEach { count[it - '0']++ }
        for (i in 0..31) {
            val j = (1 shl i)
            if (j.toString().length == l) {
                val c = IntArray(10)
                j.toString().forEach { c[it - '0']++ }
                if (count.contentEquals(c)) return true
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}