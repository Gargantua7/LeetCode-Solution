//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 👍 4 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 082
 * 含有重复元素集合的组合
 *
 * @author Gargantua丶
 * 2021-10-25 14:12:37
 */
class FourSjJUc {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            val ans = ArrayList<List<Int>>()
            candidates.sort()
            dfs(candidates, 0, ArrayList(), target, ans)
            return ans
        }

        fun dfs(nums: IntArray, index: Int, list: ArrayList<Int>, target: Int, ans: ArrayList<List<Int>>) {
            if (target == 0) {
                ans.add(ArrayList(list))
                return
            }
            for (i in index..nums.lastIndex) {
                if (nums[i] > target) return
                if (i > index && nums[i] == nums[i - 1]) continue
                list.add(nums[i])
                dfs(nums, i + 1, list, target - nums[i], ans)
                list.removeAt(list.lastIndex)
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}