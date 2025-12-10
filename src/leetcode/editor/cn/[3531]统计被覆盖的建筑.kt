//给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 
//[x, y] 的一个 唯一 建筑。 
//
// 如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。 
//
// 返回 被覆盖 的建筑数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]] 
// 
//
// 输出: 1 
//
// 解释: 
//
// 
// 只有建筑 [2,2] 被覆盖，因为它在每个方向上都至少存在一个建筑： 
// 
//
// 
// 上方 ([1,2]) 
// 下方 ([3,2]) 
// 左方 ([2,1]) 
// 右方 ([2,3]) 
// 
// 
// 因此，被覆盖的建筑数量是 1。 
//
//
// 示例 2： 
//
// 
//
// 
// 输入: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]] 
// 
//
// 输出: 0 
//
// 解释: 
//
// 
// 没有任何一个建筑在每个方向上都有至少一个建筑。 
// 
//
// 示例 3： 
//
// 
//
// 
// 输入: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]] 
// 
//
// 输出: 1 
//
// 解释: 
//
// 
// 只有建筑 [3,3] 被覆盖，因为它在每个方向上至少存在一个建筑： 
// 
//
// 
// 上方 ([1,3]) 
// 下方 ([5,3]) 
// 左方 ([3,2]) 
// 右方 ([3,5]) 
// 
// 
// 因此，被覆盖的建筑数量是 1。 
//
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 1 <= buildings.length <= 10⁵ 
// buildings[i] = [x, y] 
// 1 <= x, y <= n 
// buildings 中所有坐标均 唯一 。 
// 
//
// Related Topics 数组 哈希表 排序 👍 11 👎 0


package leetcode.editor.cn

import kotlin.math.max
import kotlin.math.min

/*** 3531
* 统计被覆盖的建筑
*
* @author Gargantua7
* 2025-12-11 00:34:52
*/
class CountCoveredBuildings {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
        val maxX = HashMap<Int, Int>()
        val maxY = HashMap<Int, Int>()
        val minX = HashMap<Int, Int>()
        val minY = HashMap<Int, Int>()

        buildings.forEach { (x, y) ->
            maxX[y] = max(maxX[y] ?: 0, x)
            minX[y] = min(minX[y] ?: n, x)
            maxY[x] = max(maxY[x] ?: 0, y)
            minY[x] = min(minY[x] ?: n, y)
        }

        return buildings.count { (x, y) ->
            x in (minX[y]!! + 1)..<maxX[y]!! && y in (minY[x]!! + 1)..<maxY[x]!!
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}