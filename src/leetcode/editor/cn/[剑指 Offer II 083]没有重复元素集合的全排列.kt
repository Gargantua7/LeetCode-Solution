//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 👍 8 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 083
 * 没有重复元素集合的全排列	
 *
 * @author Gargantua丶
 * 2021-10-25 14:13:37
 */
class VvJkup { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        val search = BooleanArray(nums.size)
        dfs(nums, search, ArrayList(), ans)
        return ans
    }

    fun dfs(nums: IntArray, search: BooleanArray, list: ArrayList<Int>, ans: ArrayList<List<Int>>) {
        if (list.size == nums.size) ans.add(ArrayList(list))

        for (i in nums.indices) {
            if (!search[i]) {
                list.add(nums[i])
                search[i] = true
                dfs(nums,search, list, ans)
                search[i] = false
                list.removeAt(list.lastIndex)
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}