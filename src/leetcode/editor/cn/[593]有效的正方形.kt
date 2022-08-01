//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
//
// Related Topics 几何 数学 👍 111 👎 0

package leetcode.editor.cn

/**
 * 593
 * 有效的正方形
 *
 * @author Gargantua丶
 * 2022-07-29 09:15:36
 */
class ValidSquare {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
            val list = listOf(p1, p2, p3, p4).map { it[0] to it[1] }.toSet().toList().takeIf { it.size == 4 } ?: return false
            val set = HashSet<Double>()
            for (i in list.indices) {
                for (j in i + 1..list.lastIndex) {
                    val (x, y) = list[i]
                    val (u, v) = list[j]
                    set += kotlin.math.sqrt(((x - u) * (x - u) + (y - v) * (y - v)).toDouble())
                }
            }
            return set.size == 2
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}