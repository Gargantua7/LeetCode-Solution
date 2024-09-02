package leetcode.editor.cn.weekly

import java.util.*
import kotlin.collections.HashMap

/**
 * @author Gargantua丶
 **/
class DoubleWeekly60 {

    fun findMiddleIndex(nums: IntArray): Int {
        val sum = nums.sum()
        var leftSum = 0
        nums.forEachIndexed { index, i ->
            val rightSum = sum - leftSum - i
            if (leftSum == rightSum) return index
            leftSum += i
        }
        return -1
    }

    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val list = ArrayList<IntArray>()
        for (i in land.indices) {
            for (j in land[0].indices) {
                if (land[i][j] == 1 && (i - 1 < 0 || land[i - 1][j] == 0) && (j - 1 < 0 || land[i][j - 1] == 0)) {
                    var currI = i
                    var currJ = j
                    while (currI + 1 < land.size && land[currI + 1][currJ] == 1) currI++
                    while (currJ + 1 < land[0].size && land[currI][currJ + 1] == 1) currJ++
                    list += intArrayOf(i, j, currI, currJ)
                }
            }
        }
        val ans = Array(list.size) { IntArray(4) }
        list.toArray(ans)
        return ans
    }

    class LockingTree(val parent: IntArray) {

        class TreeNode {

            var children = ArrayList<Int>()
            var lock = 0
        }

        val nodeList = Array(parent.size) { TreeNode() }

        init {
            parent.forEachIndexed { index, i ->
                if (i > -1) {
                    nodeList[i].children.add(index)
                }
            }
        }

        fun lock(num: Int, user: Int): Boolean {
            if (nodeList[num].lock > 0) return false
            nodeList[num].lock = user
            return true
        }

        fun unlock(num: Int, user: Int): Boolean {
            if (nodeList[num].lock != user) return false
            nodeList[num].lock = 0
            return true
        }

        fun upgrade(num: Int, user: Int): Boolean {
            var parent = num
            while (parent > -1) {
                if (nodeList[parent].lock > 0) return false
                parent = this.parent[parent]
            }
            val stack: Deque<TreeNode> = LinkedList()
            stack.push(nodeList[num])
            var isLock = false
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                if (node.lock > 0) {
                    node.lock = 0
                    if (!isLock) isLock = true
                }
                node.children.forEach { n -> stack.push(nodeList[n]) }
            }
            if (isLock) {
                nodeList[num].lock = user
            }
            return isLock
        }
    }

    val list = Array(31) { IntArray(3) }.apply {
        this[1] = intArrayOf()
        this[2] = intArrayOf(2)
        this[3] = intArrayOf(3)
        this[5] = intArrayOf(5)
        this[6] = intArrayOf(2, 3)
        this[7] = intArrayOf(7)
        this[10] = intArrayOf(2, 5)
        this[11] = intArrayOf(11)
        this[12] = intArrayOf(3, 4)
        this[13] = intArrayOf(13)
        this[14] = intArrayOf(2, 7)
        this[15] = intArrayOf(3, 5)
        this[17] = intArrayOf(17)
        this[19] = intArrayOf(19)
        this[21] = intArrayOf(3, 7)
        this[22] = intArrayOf(2, 11)
        this[23] = intArrayOf(23)
        this[29] = intArrayOf(29)
        this[30] = intArrayOf(2, 3, 5)
    }

    val l = arrayOf(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29)

    fun numberOfGoodSubsets(nums: IntArray): Int {
        var ans = 0
        val has = IntArray(l.size)
        var sum = 0
        val map = HashMap<Int, Int>()
        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        for (i in l.indices) {
            if (l[i] in map) {
                has[i] = map[l[i]]!!
                sum++
            }
        }

        return -1
    }

    fun isPrime(num: Int): Boolean {
        var isprime = true
        val len = num / 2
        for (i in 2 until len) {
            if (num % i == 0) {
                isprime = false
                break
            }
        }
        return isprime
    }

}