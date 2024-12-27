//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。 
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。 
//
// 
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 
// 
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。 
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。 
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 117 👎 0

package leetcode.editor.cn

/**
 * 433
 * 最小基因变化
 * 
 * @author Gargantua丶
 * 2022-05-07 00:33:58
 */
class MinimumGeneticMutation {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        if (end !in bank) return -1
        val map = HashMap<String, HashSet<String>>()
        bank.forEachIndexed { i, s ->
            check(s, start, map)
            for (j in i + 1..bank.lastIndex) {
                check(s, bank[j], map)
            }
        }
        val ans = dfs(map, start, end, HashSet())
        return if (ans >= 1024) -1 else ans
    }

    fun dfs(map: HashMap<String, out Set<String>>, curr: String, target: String, find: HashSet<String>): Int {
        if (curr == target) return 0
        var min = 1024
        find.add(curr)
        map[curr]?.forEach {
            if (it !in find) {
                min = minOf(min, dfs(map, it, target, find) )
            }
        }
        find.remove(curr)
        return min + 1
    }

    fun check(s1: String, s2: String,  map: HashMap<String, HashSet<String>>) {
        var any = 0
        for (i in s1.indices) {
            if (s1[i] != s2[i]) any++
            if (any > 1) return
        }
        if (any == 0) return
        map.getOrPut(s1, ::HashSet).add(s2)
        map.getOrPut(s2, ::HashSet).add(s1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
