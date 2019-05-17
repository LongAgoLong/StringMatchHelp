package com.leo.strmatchlib.entity

import com.leo.strmatchlib.interf.IProguard

/**
 * 相似比较返回结果
 */
class SimilarityResult : IProguard {
    var step: Int? = null
    var score: Double? = null
    var target: String? = null

    constructor(step: Int = 0, score: Double = 0.0, target: String) {
        this.step = step
        this.score = score
        this.target = target
    }

    override fun toString(): String {
        return "SimilarityResult(step=$step, score=$score, target=$target)"
    }
}