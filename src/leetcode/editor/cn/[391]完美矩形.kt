//给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是
// (xi, yi) ，右上顶点是 (ai, bi) 。 
//
// 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
//输出：true
//解释：5 个矩形一起可以精确地覆盖一个矩形区域。 
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
//输出：false
//解释：两个矩形之间有间隔，无法覆盖成一个矩形。 
//
// 示例 3： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
//输出：false
//解释：图形顶端留有空缺，无法覆盖成一个矩形。 
//
// 示例 4： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
//输出：false
//解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 2 * 10⁴ 
// rectangles[i].length == 4 
// -10⁵ <= xi, yi, ai, bi <= 10⁵ 
// 
// Related Topics 数组 扫描线 👍 162 👎 0

package leetcode.editor.cn

/**
 * 391
 * 完美矩形	
 *
 * @author Gargantua丶
 * 2021-11-16 15:15:27
 */
class PerfectRectangle { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
        val count = HashMap<Point, Int>()
        var (minX, minY, maxX, maxY) = rectangles[0]
        val area = rectangles.fold(0L) { sum, (x, y, a, b) ->
            minX = minX.coerceAtMost(x)
            minY = minY.coerceAtMost(y)
            maxX = maxX.coerceAtLeast(a)
            maxY = maxY.coerceAtLeast(b)

            val point1 = Point(x, y)
            val point2 = Point(x, b)
            val point3 = Point(a, y)
            val point4 = Point(a, b)

            count[point1] = (count[point1]?: 0) + 1
            count[point2] = (count[point2]?: 0) + 1
            count[point3] = (count[point3]?: 0) + 1
            count[point4] = (count[point4]?: 0) + 1

            sum + (a - x) * (b - y)
        }

        val pointLD = Point(minX, minY)
        val pointLU = Point(minX, maxY)
        val pointRD = Point(maxX, minY)
        val pointRU = Point(maxX, maxY)

        if (area != ((maxX - minX) * (maxY - minY)).toLong()
            || (count[pointLD]?: 0) != 1 || (count[pointLU]?: 0) != 1
            || (count[pointRD]?: 0) != 1 || (count[pointRU]?: 0) != 1) {
            return false
        }

        count -= pointLD
        count -= pointLU
        count -= pointRD
        count -= pointRU

        count.values.forEach { if (it != 2 && it != 4) return false }
        return true
    }

    data class Point(val x: Int, val y: Int)
}
//leetcode submit region end(Prohibit modification and deletion)

}