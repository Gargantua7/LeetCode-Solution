//给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来
//判断，这些点是否在该坐标系中属于同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
// Related Topics 几何 数组 数学 👍 105 👎 0

package leetcode.editor.cn

/**
 * 1232
 * 缀点成线
 * 
 * @author Gargantua丶
 * 2022-03-21 01:03:30
 */
class CheckIfItIsAStraightLine {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val deltaX = coordinates[0][0]
        val deltaY = coordinates[0][1]
        val n = coordinates.size
        for (i in 0 until n) {
            coordinates[i][0] -= deltaX
            coordinates[i][1] -= deltaY
        }
        val a = coordinates[1][1]
        val b = -coordinates[1][0]
        for (i in 2 until n) {
            val x = coordinates[i][0]
            val y = coordinates[i][1]
            if (a * x + b * y != 0) {
                return false
            }
        }
        return true
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
