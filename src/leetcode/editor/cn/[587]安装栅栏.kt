//在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能
//围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
//解释:
//
// 
//
// 示例 2: 
//
// 输入: [[1,2],[2,2],[4,2]]
//输出: [[1,2],[2,2],[4,2]]
//解释:
//
//即使树都在一条直线上，你也需要先用绳子包围它们。
// 
//
// 
//
// 注意: 
//
// 
// 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。 
// 输入的整数在 0 到 100 之间。 
// 花园至少有一棵树。 
// 所有树的坐标都是不同的。 
// 输入的点没有顺序。输出顺序也没有要求。 
// Related Topics 几何 数组 数学 👍 140 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 587
 * 安装栅栏
 * 
 * @author Gargantua丶
 * 2022-04-23 12:09:34
 */
class ErectTheFence {
//leetcode submit region begin(Prohibit modification and deletion)
internal class Solution {
    fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
        val n = trees.size
        if (n < 4) {
            return trees
        }
        /* 按照 x 大小进行排序，如果 x 相同，则按照 y 的大小进行排序 */Arrays.sort(trees) { a: IntArray, b: IntArray ->
            if (a[0] == b[0]) {
                return@sort a[1] - b[1]
            }
            a[0] - b[0]
        }
        val hull: MutableList<Int> = ArrayList()
        val used = BooleanArray(n)
        /* hull[0] 需要入栈两次，不进行标记 */hull.add(0)
        /* 求出凸包的下半部分 */for (i in 1 until n) {
            while (hull.size > 1 && cross(trees[hull[hull.size - 2]], trees[hull[hull.size - 1]], trees[i]) < 0) {
                used[hull[hull.size - 1]] = false
                hull.removeAt(hull.size - 1)
            }
            used[i] = true
            hull.add(i)
        }
        val m = hull.size
        /* 求出凸包的上半部分 */for (i in n - 2 downTo 0) {
            if (!used[i]) {
                while (hull.size > m && cross(trees[hull[hull.size - 2]], trees[hull[hull.size - 1]], trees[i]) < 0) {
                    used[hull[hull.size - 1]] = false
                    hull.removeAt(hull.size - 1)
                }
                used[i] = true
                hull.add(i)
            }
        }
        /* hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0] */hull.removeAt(hull.size - 1)
        val size = hull.size
        val res = Array(size) { IntArray(2) }
        for (i in 0 until size) {
            res[i] = trees[hull[i]]
        }
        return res
    }

    fun cross(p: IntArray, q: IntArray, r: IntArray): Int {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0])
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
