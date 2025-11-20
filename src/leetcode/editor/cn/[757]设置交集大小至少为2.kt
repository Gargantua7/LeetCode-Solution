//给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数
//，包括 starti 和 endi 。 
//
// 包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。 
//
// 
// 例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包
//含集合 的定义。 
// 
//
// 返回包含集合可能的最小大小。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[3,7],[8,9]]
//输出：5
//解释：nums = [2, 3, 4, 8, 9].
//可以证明不存在元素数量为 4 的包含集合。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,3],[1,4],[2,5],[3,5]]
//输出：3
//解释：nums = [2, 3, 4].
//可以证明不存在元素数量为 2 的包含集合。 
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,2],[2,3],[2,4],[4,5]]
//输出：5
//解释：nums = [1, 2, 3, 4, 5].
//可以证明不存在元素数量为 4 的包含集合。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 3000 
// intervals[i].length == 2 
// 0 <= starti < endi <= 10⁸ 
// 
//
// Related Topics 贪心 数组 排序 👍 219 👎 0


package leetcode.editor.cn

/*** 757
* 设置交集大小至少为2
*
* @author Gargantua7
* 2025-11-20 22:01:25
*/
class SetIntersectionSizeAtLeastTwo {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        intervals.sortWith { (s1, e1), (s2, e2) ->
            if (s1 == s2) e2 - e1 else s1 - s2
        }

        val temp = Array(intervals.size) { ArrayList<Int>() }

        var res = 0

        for (i in intervals.indices.reversed()) {
            var j = intervals[i][0]
            var k = temp[i].size
            while (k < 2) {
                res++

                for (x in i - 1 downTo 0) {
                    if (intervals[x][1] < j) break
                    temp[x].add(j)
                }

                j++
                k++
            }
        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}