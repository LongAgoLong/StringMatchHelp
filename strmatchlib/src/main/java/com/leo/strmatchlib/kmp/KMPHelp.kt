package com.leo.strmatchlib.kmp

/**
 * 字符串匹配KMP算法
 */
class KMPHelp {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            KMPHelp()
        }
    }
}