//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1277 👎 0


package leetcode.editor.cn

/**
 * 90
 * 子集 II
 * 
 * @author Gargantua丶
 * 2025-02-05 15:15:11
 */
private class SubsetsIi {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>(emptyList())
        nums.groupBy { it }.forEach { (num, list) ->
            val end = res.lastIndex
            for (i in 0..end) {
                for (j in 1..list.size) {
                    res.add(res[i] + list.subList(0, j))
                }
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}