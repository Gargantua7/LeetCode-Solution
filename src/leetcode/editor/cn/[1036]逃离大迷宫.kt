//在一个 10⁶ x 10⁶ 的网格中，每个网格上方格的坐标为 (x, y) 。 
//
// 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表
//，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。 
//
// 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。 
//
// 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
//输出：false
//解释：
//从源方格无法到达目标方格，因为我们无法在网格中移动。
//无法向北或者向东移动是因为方格禁止通行。
//无法向南或者向西移动是因为不能走出网格。 
//
// 示例 2： 
//
// 
//输入：blocked = [], source = [0,0], target = [999999,999999]
//输出：true
//解释：
//因为没有方格被封锁，所以一定可以到达目标方格。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= blocked.length <= 200 
// blocked[i].length == 2 
// 0 <= xi, yi < 10⁶ 
// source.length == target.length == 2 
// 0 <= sx, sy, tx, ty < 10⁶ 
// source != target 
// 题目数据保证 source 和 target 不在封锁列表内 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 哈希表 👍 68 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet
import kotlin.collections.MutableSet
import kotlin.collections.Set


/**
 * 1036
 * 逃离大迷宫
 *
 * @author Gargantua丶
 * 2022-01-11 01:12:49
 */
class EscapeALargeMaze {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 在包围圈中
    val BLOCKED = -1

    // 不在包围圈中
    val VALID = 0

    // 无论在不在包围圈中，但在 n(n-1)/2 步搜索的过程中经过了 target
    val FOUND = 1

    val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    val BOUNDARY = 1000000

    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        if (blocked.size < 2) {
            return true
        }
        val hashBlocked = HashSet<Pair<Int, Int>>()
        blocked.forEach { (a, b) ->
            hashBlocked.add(a to b)
        }
        var result = check(blocked, source, target, hashBlocked)
        return if (result == FOUND) {
            true
        } else if (result == BLOCKED) {
            false
        } else {
            result = check(blocked, target, source, hashBlocked)
            result != BLOCKED
        }
    }

    fun check(
        blocked: Array<IntArray>,
        start: IntArray,
        finish: IntArray,
        hashBlocked: Set<Pair<Int, Int>>
    ): Int {
        val sx = start[0]
        val sy = start[1]
        val fx = finish[0]
        val fy = finish[1]
        var countdown = blocked.size * (blocked.size - 1) / 2
        val startPair = sx to sy
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(startPair)
        val visited = HashSet<Pair<Int, Int>>()
        visited.add(startPair)
        while (!queue.isEmpty() && countdown > 0) {
            val (x, y) = queue.removeFirst()
            for (d in 0..3) {
                val nx = x + dirs[d][0]
                val ny = y + dirs[d][1]
                val newPair = nx to ny
                if (nx in 0 until BOUNDARY && ny >= 0 && ny < BOUNDARY && !hashBlocked.contains(newPair) && !visited.contains(
                        newPair
                    )
                ) {
                    if (nx == fx && ny == fy) {
                        return FOUND
                    }
                    --countdown
                    queue.addLast(newPair)
                    visited.add(newPair)
                }
            }
        }
        return if (countdown > 0) {
            BLOCKED
        } else VALID
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
