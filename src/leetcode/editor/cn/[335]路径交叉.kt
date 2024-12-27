//给你一个整数数组 distance 。 
//
// 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2
//] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。 
//
// 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：distance = [2,1,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：distance = [1,2,3,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：distance = [1,1,1,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= distance.length <= 10⁵ 
// 1 <= distance[i] <= 10⁵ 
// 
// Related Topics 几何 数组 数学 👍 59 👎 0

package leetcode.editor.cn

/**
 * 335
 * 路径交叉
 *
 * @author Gargantua丶
 * 2021-10-29 00:21:00
 */
class SelfCrossing {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isSelfCrossing(distance: IntArray): Boolean {
            for (i in 3..distance.lastIndex) {
                if (distance[i] >= distance[i - 2] && distance[i - 3] >= distance[i - 1]) return true
                if (i == 4 && distance[1] == distance[3] && distance[4] + distance[0] >= distance[2]) return true
                if (i >= 5 && distance[i - 3] - distance[i - 1] in 0..distance[i - 5] &&
                    distance[i - 2] - distance[i - 4] in 0..distance[i]) return true
            }
            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}