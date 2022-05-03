//两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。 
//
// 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。 
//
// 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。 
//
// 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。 
//
// 此外，猫无法移动到洞中（节点 0）。 
//
// 然后，游戏在出现以下三种情形之一时结束： 
//
// 
// 如果猫和老鼠出现在同一个节点，猫获胜。 
// 如果老鼠到达洞中，老鼠获胜。 
// 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。 
// 
//
// 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏： 
//
// 
// 如果老鼠获胜，则返回 1； 
// 如果猫获胜，则返回 2； 
// 如果平局，则返回 0 。 
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
//输出：0
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,3],[0],[3],[0,2]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= graph.length <= 50 
// 1 <= graph[i].length < graph.length 
// 0 <= graph[i][j] < graph.length 
// graph[i][j] != i 
// graph[i] 互不相同 
// 猫和老鼠在游戏中总是移动 
// 
// Related Topics 广度优先搜索 图 记忆化搜索 数学 动态规划 博弈 👍 208 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 913
 * 猫和老鼠
 * 
 * @author Gargantua丶
 * 2022-01-04 22:06:23
 */
class CatAndMouse {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var n = 0
    lateinit var graph: Array<IntArray>
    lateinit var dp: Array<Array<IntArray>>
    fun catMouseGame(graph: Array<IntArray>): Int {
        n = graph.size
        this.graph = graph
        dp = Array(n) { Array(n) { IntArray(n * 2) } }
        for (i in 0 until n) {
            for (j in 0 until n) {
                Arrays.fill(dp[i][j], -1)
            }
        }
        return getResult(1, 2, 0)
    }

    fun getResult(mouse: Int, cat: Int, turns: Int): Int {
        if (turns == n * 2) {
            return DRAW
        }
        if (dp[mouse][cat][turns] < 0) {
            if (mouse == 0) {
                dp[mouse][cat][turns] = MOUSE_WIN
            } else if (cat == mouse) {
                dp[mouse][cat][turns] = CAT_WIN
            } else {
                getNextResult(mouse, cat, turns)
            }
        }
        return dp[mouse][cat][turns]
    }

    fun getNextResult(mouse: Int, cat: Int, turns: Int) {
        val curMove = if (turns % 2 == 0) mouse else cat
        val defaultResult = if (curMove == mouse) CAT_WIN else MOUSE_WIN
        var result = defaultResult
        val nextNodes = graph[curMove]
        for (next in nextNodes) {
            if (curMove == cat && next == 0) {
                continue
            }
            val nextMouse = if (curMove == mouse) next else mouse
            val nextCat = if (curMove == cat) next else cat
            val nextResult = getResult(nextMouse, nextCat, turns + 1)
            if (nextResult != defaultResult) {
                result = nextResult
                if (result != DRAW) {
                    break
                }
            }
        }
        dp[mouse][cat][turns] = result
    }

    companion object {
        const val MOUSE_WIN = 1
        const val CAT_WIN = 2
        const val DRAW = 0
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
