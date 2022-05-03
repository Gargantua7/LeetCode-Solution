//给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。 
//
// 每个人都可能不喜欢其他人，那么他们不应该属于同一组。 
//
// 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。 
//
// 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 2000 
// 0 <= dislikes.length <= 10000 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= N 
// dislikes[i][0] < dislikes[i][1] 
// 对于 dislikes[i] == dislikes[j] 不存在 i != j 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 144 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 886
 * 可能的二分法
 *
 * @author Gargantua丶
 * 2021-11-25 14:10:44
 */
class PossibleBipartition {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
            val map = HashMap<Int, ArrayList<Int>>()
            dislikes.forEach { (i, j) ->
                if (i - 1 !in map) map[i - 1] = ArrayList()
                if (j - 1 !in map) map[j - 1] = ArrayList()
                map[i - 1]!!.add(j - 1)
                map[j - 1]!!.add(i - 1)
            }
            val group = IntArray(n)
            val queue: Queue<Int> = LinkedList()
            for (i in group.indices) {
                if (group[i] == 0) {
                    group[i] = 1
                    queue.offer(i)
                    while (queue.isNotEmpty()) {
                        val node = queue.poll()
                        map[node]?.forEach { j ->
                            when (group[j]) {
                                0 -> {
                                    queue.offer(j)
                                    group[j] = -group[node]
                                }
                                group[node] -> return false
                            }
                        }
                    }
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}