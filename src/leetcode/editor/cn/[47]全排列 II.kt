//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 排序 👍 1651 👎 0


package leetcode.editor.cn

/**
 * 47
 * 全排列 II
 * 
 * @author Gargantua丶
 * 2025-02-06 10:06:30
 */
private class PermutationsIi {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()
        dfs(nums, BooleanArray(nums.size), mutableListOf(), res)
        return res
    }

    fun dfs(nums: IntArray, used: BooleanArray, path: MutableList<Int>, res: MutableList<List<Int>>) {
        if (path.size == nums.size) {
            res.add(path.toList())
            return
        }
        for (i in nums.indices) {
            if (used[i]) continue
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue
            used[i] = true
            path.add(nums[i])
            dfs(nums, used, path, res)
            path.removeAt(path.lastIndex)
            used[i] = false
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}