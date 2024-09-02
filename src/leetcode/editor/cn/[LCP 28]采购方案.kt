//小力将 N 个零件的报价存于数组 `nums`。小力预算为 `target`，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
//
//
//注意：答案需要以 `1e9 + 7 (1000000007)` 为底取模，如：计算初始结果为：`1000000008`，请返回 `1`
//
//
//**示例 1：**
//>输入：`nums = [2,5,3,5], target = 6`
//>
//>输出：`1`
//>
//>解释：预算内仅能购买 nums[0] 与 nums[2]。
//
//**示例 2：**
//>输入：`nums = [2,2,1,9], target = 10`
//>
//>输出：`4`
//>
//>解释：符合预算的采购方案如下：
//>nums[0] + nums[1] = 4
//>nums[0] + nums[2] = 3
//>nums[1] + nums[2] = 3
//>nums[2] + nums[3] = 10
//
//**提示：**
//- `2 <= nums.length <= 10^5`
//- `1 <= nums[i], target <= 10^5`
// Related Topics 数组 双指针 二分查找 排序 👍 29 👎 0


package leetcode.editor.cn


/**
 * LCP 28
 * 采购方案
 *
 * @author Gargantua丶
 * 2021-08-28 02:19:48
 */
class FourXy4Wx {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun purchasePlans(nums: IntArray, target: Int): Int {
            var ans = 0
            val mod = 1000000007
            nums.sort()
            var left = 0
            var right = nums.lastIndex
            while (left < right) {
                while (left < right && nums[left] + nums[right] > target) right--
                if (left < right) ans = (ans + right - left) % mod
                left++
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}