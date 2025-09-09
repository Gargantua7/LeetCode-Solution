//在第 1 天，有一个人发现了一个秘密。 
//
// 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。同时给你一个整数 forget ，表示每个人在
//发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。 
//
// 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 6, delay = 2, forget = 4
//输出：5
//解释：
//第 1 天：假设第一个人叫 A 。（一个人知道秘密）
//第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
//第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
//第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
//第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
//第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
// 
//
// 示例 2： 
//
// 输入：n = 4, delay = 1, forget = 3
//输出：6
//解释：
//第 1 天：第一个知道秘密的人为 A 。（一个人知道秘密）
//第 2 天：A 把秘密分享给 B 。（两个人知道秘密）
//第 3 天：A 和 B 把秘密分享给 2 个新的人 C 和 D 。（四个人知道秘密）
//第 4 天：A 忘记了秘密，B、C、D 分别分享给 3 个新的人。（六个人知道秘密）
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 1 <= delay < forget <= n 
// 
//
// Related Topics 队列 动态规划 模拟 👍 113 👎 0


package leetcode.editor.cn

/**
 * 2327
 * 知道秘密的人数
 * 
 * @author Gargantua丶
 * 2025-09-09 15:11:14
 */
private class NumberOfPeopleAwareOfASecret {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    companion object {
        const val MOD = 1_000_000_007
    }

    fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
        // teller: forget - delay
        // knower: delay
        // sum = teller + knower = forget
        // two part: [0, forget - delay) => teller; [forget - delay, forget) => knower
        val list = ArrayDeque<Long>(forget)
        repeat(forget - 1) { list.addLast(0) }
        list.addLast(1)
        var teller = 0L

        repeat(n - 1) {
            teller += list[forget - delay] // knower to new teller
            teller -= list.removeFirst() // forgot
            teller = (teller + MOD) % MOD
            list.addLast(teller) // teller telling
        }

        return list.fold(0) { acc, i -> ((acc.toLong() + i) % MOD).toInt() }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

// size: 4
//    [  T  /  K ]
// 1: [0, 0, 0, 1]
// 2: [0, 0, 1, 0]
// 3: [0, 1, 0, 1]
// 4: [1, 0, 1, 1]
// 5: [0, 1, 1, 1]
// 6: [1, 1, 1, 2]