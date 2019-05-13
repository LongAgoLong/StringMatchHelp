package com.leo.strmatchlib.similarity

import android.text.TextUtils
import androidx.annotation.NonNull

/**
 * 字符串匹配相似算法
 */
class SimilarityHelp {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            SimilarityHelp()
        }
    }

    /**
     * 返回相似度最高的字符串
     */
    fun compare(@NonNull source: String, @NonNull list: MutableList<String>): String {
        var step = 0
        var result = ""
        /**
         * 利用run+标签来跳出循环
         */
        run loop@{
            list.forEach(action = {
                val matchStep = compare(source, it)
                if (TextUtils.isEmpty(result)) {
                    step = matchStep
                    result = it
                } else if (matchStep <= step) {
                    step = matchStep
                    result = it
                    if (step == 0) {
                        return@loop
                    }
                }
            })
        }
        return result
    }

    /**
     * 返回莱茵斯坦距离/差异步骤
     * 差异步骤越小相似度越高
     */
    fun compare(source: String, target: String): Int {
        if (TextUtils.equals(source, target)) {
            return 0
        }
        val sourceCharArray = source.toCharArray()
        val targetCharArray = target.toCharArray()
        val sourceLen = sourceCharArray.size
        val targetLen = targetCharArray.size
        val d = Array(sourceLen + 1) { IntArray(targetLen + 1) }
        for (i in 0..sourceLen) {
            d[i][0] = i
        }
        for (i in 0..targetLen) {
            d[0][i] = i
        }
        for (i in 1..sourceLen) {
            for (j in 1..targetLen) {
                if (sourceCharArray[i - 1] == targetCharArray[j - 1]) {
                    d[i][j] = d[i - 1][j - 1]
                } else {
                    // 插入
                    val insert = d[i][j - 1] + 1
                    // 删除
                    val delete = d[i - 1][j] + 1
                    // 替换
                    val replace = d[i - 1][j - 1] + 1
                    d[i][j] = if (Math.min(insert, delete) > Math.min(delete, replace))
                        Math.min(delete, replace) else Math.min(insert, delete)
                }
            }
        }
        return d[sourceLen][targetLen]
    }

    /**
     * 莱茵斯坦距离/差异步骤 -> 分数值
     * 分数值越大越相似
     */
    fun toScore(step: Int, len1: Int, len2: Int): Double {
        return 1 - step.toDouble() / Math.max(len1, len2)
    }
}