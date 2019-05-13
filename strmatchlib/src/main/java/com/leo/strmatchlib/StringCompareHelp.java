package com.leo.strmatchlib;

import androidx.annotation.NonNull;

import com.leo.strmatchlib.similarity.SimilarityHelp;

import java.util.List;

/**
 * 字符串匹配算法
 * 对外工具类
 */
public class StringCompareHelp {
    private StringCompareHelp() {
    }

    /**
     * 相似度匹配算法
     *
     * @param source  源
     * @param targets 目标list
     * @return 最相似的字符串
     */
    public static String similarityCompare(@NonNull String source, @NonNull List<String> targets) {
        return SimilarityHelp.Companion.getInstance().compare(source, targets);
    }

    /**
     * 相似度匹配算法
     *
     * @param sourece 源
     * @param target  比较文本
     * @return 差异步骤-值越小越相似
     */
    public static int similarityCompare(@NonNull String sourece, @NonNull String target) {
        return SimilarityHelp.Companion.getInstance().compare(sourece, target);
    }

    /**
     * 差异步骤转成分数值
     *
     * @param step
     * @param sourceLen
     * @param targetLen
     * @return 分数值-值越大越相似
     */
    public static double similarityStepToScore(int step, int sourceLen, int targetLen) {
        return SimilarityHelp.Companion.getInstance().toScore(step, sourceLen, targetLen);
    }
}
