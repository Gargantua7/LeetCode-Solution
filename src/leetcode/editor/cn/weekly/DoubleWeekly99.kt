package leetcode.editor.cn.weekly

class DoubleWeekly99 {

    fun splitNum(num: Int): Int {
        val s = num.toString()
        var n1 = 0
        var n2 = 0
        s.toCharArray().sorted().forEachIndexed { index, c ->
            if (index % 2 == 0) {
                n1 *= 10
                n1 += c - '0'
            } else {
                n2 *= 10
                n2 += c - '0'
            }
        }
        return n1 + n2
    }

    fun coloredCells(n: Int): Long {
        var ans = 1L
        repeat(n) {
            ans += it * 4
        }
        return ans
    }

    fun countWays(ranges: Array<IntArray>): Int {
        ranges.sortWith(Comparator { o1: IntArray, o2: IntArray ->
            if (o1[1] != o2[1]) o1[1] - o2[1] else o1[0] - o2[0]
        })
        ranges.forEach { print(it.contentToString() + ", ") }
        var count = 0
        var end = -1
        ranges.forEach { (s, e) ->
            if (s > end) {
                count++
            }
            end = maxOf(end, e)
        }
        var ans = 1L
        repeat(count) {
            ans *= 2
            ans %= (1e9 + 7).toInt()
        }
        return ans.toInt()
    }


    fun rootCount(edges: Array<IntArray>, guesses: Array<IntArray>, k: Int): Int {
        val score = HashMap<Pair<Int, Int>, Int>()
        val map = HashMap<Int, ArrayList<Int>>()
        val set = guesses.map { (a, b) -> a to b }.toSet()
        edges.forEach { (a, b) ->
            map.getOrPut(a, ::ArrayList).add(b)
            map.getOrPut(b, ::ArrayList).add(a)
        }
        val node = map.keys
        var ans = 0
        node.forEach { root ->
            val count = dfs(map, root, HashSet(), set, score)
            if (count >= k) ans++
        }
        return ans
    }

    fun dfs(map: HashMap<Int, out List<Int>>, curr: Int, search: HashSet<Int>, set: Set<Pair<Int, Int>>, score: HashMap<Pair<Int, Int>, Int>): Int {
        search.add(curr)
        var count = 0
        map[curr]?.forEach { next ->
            if (next in search) return@forEach
            count += if (curr to next in score) {
                score[curr to next]!!
            } else {
                var countNext = dfs(map, next, search, set, score)
                if (curr to next in set) countNext++
                score[curr to next] = countNext
                countNext
            }
        }
        return count
    }
}