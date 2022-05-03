//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
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
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 👍 5 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 084
 * 含有重复元素集合的全排列
 *
 * @author Gargantua丶
 * 2021-10-25 14:43:55
 */
class SevenP8L0Z {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun permuteUnique(nums: IntArray): List<List<Int>> {
            val ans = ArrayList<List<Int>>()
            val search = BooleanArray(nums.size)
            nums.sort()
            dfs(nums, search, ArrayList(), ans)
            return ans
        }

        fun dfs(nums: IntArray, search: BooleanArray, list: ArrayList<Int>, ans: ArrayList<List<Int>>) {
            if (list.size == nums.size) ans.add(ArrayList(list))

            for (i in nums.indices) {
                if (!search[i] && (i == 0 || search[i - 1] || nums[i] != nums[i - 1])) {
                    list.add(nums[i])
                    search[i] = true
                    dfs(nums, search, list, ans)
                    search[i] = false
                    list.removeAt(list.lastIndex)
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}