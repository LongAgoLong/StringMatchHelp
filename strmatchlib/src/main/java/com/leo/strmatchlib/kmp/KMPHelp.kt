package com.leo.strmatchlib.kmp

/**
 * 字符串匹配
 * KMP算法
 */
class KMPHelp {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            KMPHelp()
        }
    }

    /**
     * 求出一个字符数组的next数组
     * @param t 字符数组
     * @return next数组
     */
    private fun getNextArray(t: CharArray): IntArray {
        val next = IntArray(t.size)
        next[0] = -1
        next[1] = 0
        var k: Int
        for (j in 2 until t.size) {
            k = next[j - 1]
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1
                    break
                } else {
                    k = next[k]
                }
                next[j] = 0  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    fun match(s: String, t: String): Int {
        val sArr = s.toCharArray()
        val tArr = t.toCharArray()
        val next = getNextArray(tArr)
        var i = 0
        var j = 0
        while (i < sArr.size && j < tArr.size) {
            if (j == -1 || sArr[i] == tArr[j]) {
                i++
                j++
            } else
                j = next[j]
        }
        return if (j == tArr.size)
            i - j
        else
            -1
    }
}