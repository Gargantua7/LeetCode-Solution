//给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。 
//
// 每个矩形由其 左下 顶点和 右上 顶点坐标表示： 
//
// 
// 
// 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。 
// 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
//输出：45
// 
//
// 示例 2： 
//
// 
//输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴ 
// 
// Related Topics 几何 数学 👍 123 👎 0


package leetcode.editor.cn

/**
 * 223
 * 矩形面积
 *
 * @author Gargantua丶
 * 2021-09-30 01:03:30
 */
class RectangleArea {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //              -5          4       0           5       -3          -3          3       3
        fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
            val sum = (ax2 - ax1) * (ay2 - ay1) + (by2 - by1) * (bx2 - bx1)
            if (ax1 >= bx2 || ax2 <= bx1 || ay1 >= by2 || ay2 <= by1) return sum
            val x1 = maxOf(ax1, bx1)
            val x2 = minOf(ax2, bx2)
            val y1 = maxOf(ay1, by1)
            val y2 = minOf(ay2, by2)
            return sum - (x2 - x1) * (y2 - y1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}