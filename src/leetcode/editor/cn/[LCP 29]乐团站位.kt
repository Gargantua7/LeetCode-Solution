//某乐团的演出场地可视作 `num * num` 的二维矩阵 `grid`（左上角坐标为 `[0,0]`)，每个位置站有一位成员。乐团共有 `9` 种乐器，乐
//器编号为 `1~9`，每位成员持有 `1` 个乐器。
//
//为保证声乐混合效果，成员站位规则为：自 `grid` 左上角开始顺时针螺旋形向内循环以 `1，2，...，9` 循环重复排列。例如当 num = `5` 时
//，站位如图所示
//
//![image.png](https://pic.leetcode-cn.com/1616125411-WOblWH-image.png)
//
//
//请返回位于场地坐标 [`Xpos`,`Ypos`] 的成员所持乐器编号。
//
//**示例 1：**
//>输入：`num = 3, Xpos = 0, Ypos = 2`
//>
//>输出：`3`
//>
//>解释：
//![image.png](https://pic.leetcode-cn.com/1616125437-WUOwsu-image.png)
//
//
//**示例 2：**
//>输入：`num = 4, Xpos = 1, Ypos = 2`
//>
//>输出：`5`
//>
//>解释：
//![image.png](https://pic.leetcode-cn.com/1616125453-IIDpxg-image.png)
//
//
//**提示：**
//- `1 <= num <= 10^9`
//- `0 <= Xpos, Ypos < num` Related Topics 数学 👍 43 👎 0


package leetcode.editor.cn

/**
 * LCP 29
 * 乐团站位
 *
 * @author Gargantua丶
 * 2021-08-28 02:19:47
 */
class SNJvJP {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun orchestraLayout(num: Int, xPos: Int, yPos: Int): Int {
            val depth = xPos.coerceAtMost(yPos).coerceAtMost(
                (num - xPos - 1).coerceAtMost(num - yPos - 1)
            ).toLong()
            val n = num - depth * 2
            val outer = num.toLong() * num.toLong() - n * n
            val start = outer % 9 + 1
            val inner = (n - 1) * 4
            var dist = xPos + yPos - 2 * depth
            if (xPos.toLong() == n + depth - 1 || (yPos.toLong() == depth && xPos.toLong() != depth)) {
                dist = inner - dist
            }
            return ((dist + start - 1) % 9 + 1).toInt()
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
fun orchestraLayout(num: Int, xPos: Int, yPos: Int): Int {
    val deep = xPos.coerceAtMost(yPos).coerceAtMost((num - xPos - 1).coerceAtMost(num - yPos - 1)).toLong()
    val n = num - (deep * 2).toInt()
    var count = (num.toLong() * deep - deep * deep) * 4
    val start = ((count) % 9 + 1).toInt()
    count = (n.toLong() - 1) * 4
    var dist = xPos.toLong() + yPos.toLong() - 2 * deep
    if (xPos.toLong() == n + deep - 1 || yPos.toLong() == deep && xPos.toLong() != deep) {
        dist = count - dist
    }
    return ((dist + start - 1) % 9 + 1).toInt()
}
}