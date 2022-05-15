//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。 
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
// Related Topics 几何 数组 数学 👍 155 👎 0

package leetcode.editor.cn

/**
 * 812
 * 最大三角形面积
 * 
 * @author Gargantua丶
 * 2022-05-15 20:09:10
 */
class LargestTriangleArea {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        var res = 0.0
        for (i in points.indices) {
            for (j in i + 1..points.lastIndex) {
                for (k in j + 1..points.lastIndex) {
                    val p1 = points[i][0].toDouble() to points[i][1].toDouble()
                    val p2 = points[j][0].toDouble() to points[j][1].toDouble()
                    val p3 = points[k][0].toDouble() to points[k][1].toDouble()
                    val area = 0.5 * kotlin.math.abs(p1.first * p2.second + p2.first * p3.second + p3.first * p1.second - p1.first * p3.second - p2.first * p1.second - p3.first * p2.second)
                    res = res.coerceAtLeast(area)
                }
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
