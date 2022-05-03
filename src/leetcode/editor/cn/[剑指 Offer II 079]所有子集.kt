//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// 
//
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
// Related Topics 位运算 数组 回溯 👍 6 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 079
 * 所有子集
 *
 * @author Gargantua丶
 * 2021-10-24 12:56:22
 */
class TVdhkn { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        ans += emptyList<Int>()
        for(i in nums.indices) dfs(nums, i, ArrayList(), ans)
        return ans
    }

    fun dfs(nums: IntArray, index: Int, list: ArrayList<Int>, ans: ArrayList<List<Int>>) {
        if (index !in nums.indices) return
        list.add(nums[index])
        ans.add(ArrayList(list))
        for (i in index + 1..nums.lastIndex) dfs(nums, i, list, ans)
        list.removeAt(list.lastIndex)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}