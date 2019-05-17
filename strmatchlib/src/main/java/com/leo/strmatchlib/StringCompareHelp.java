package com.leo.strmatchlib;

import androidx.annotation.NonNull;

import com.leo.strmatchlib.entity.SimilarityResult;
import com.leo.strmatchlib.kmp.KMPHelp;
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
    public static SimilarityResult similarityCompare(@NonNull String source,
                                                     @NonNull List<String> targets) {
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
     * 排序
     *
     * @param source  源
     * @param targets 目标list
     * @return 排序后的字符串list-按分数值降序
     */
    public static List<SimilarityResult> similarityCompareSort(@NonNull String source,
                                                               @NonNull List<String> targets) {
        return SimilarityHelp.Companion.getInstance().compareSort(source, targets);
    }

    /**
     * 差异步骤转成分数值
     *
     * @param step      源
     * @param sourceLen 源字符串的长度
     * @param targetLen 目标字符串的长度
     * @return 分数值-值越大越相似
     */
    public static double similarityStepToScore(int step, int sourceLen, int targetLen) {
        return SimilarityHelp.Companion.getInstance().toScore(step, sourceLen, targetLen);
    }

    /**
     * KMP匹配算法
     *
     * @param sourece 源
     * @param target  比较文本
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(@NonNull String sourece, @NonNull String target) {
        return KMPHelp.Companion.getInstance().match(sourece, target);
    }
}
