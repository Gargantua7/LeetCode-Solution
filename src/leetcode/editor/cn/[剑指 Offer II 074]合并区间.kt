//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/ 
// Related Topics 数组 排序 👍 5 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 074
 * 合并区间
 *
 * @author Gargantua丶
 * 2021-10-22 13:13:37
 */
class SsGoHC {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            intervals.sortWith(kotlin.Comparator { (s1, e1), (s2, e2) ->
                if (s1 != s2) s1 - s2 else e1 - e2
            })
            val list = ArrayList<IntArray>()
            var l = intervals[0][0]
            var r = intervals[0][1]
            intervals.forEach { (s, e) ->
                if (s <= r) r = maxOf(r, e)
                else {
                    list += intArrayOf(l, r)
                    l = s
                    r = e
                }
            }
            list += intArrayOf(l, r)
            val ans = Array(list.size) { IntArray(2) }
            return list.toArray(ans)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}