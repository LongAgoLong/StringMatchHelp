package com.leo.kmpalgorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leo.strmatchlib.StringCompareHelp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val s0 = "鞋子不能在实体店买"
    val s1 = "鞋子不能在店里买"
    val s2 = "不能在实体店买鞋"
    val s3 = "鞋子不能在实体店买啊"
    val s4 = "鞋子不能在实体买"
    val list = listOf(s1, s2, s3, s4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val similarityCompare = StringCompareHelp.similarityCompare(s1, s2)
        resultTv.text = "差异步骤:"
        resultTv.append(similarityCompare.toString())
        resultTv.append("\n相似度：")
        resultTv.append(StringCompareHelp.similarityStepToScore(similarityCompare, s1.length, s2.length).toString())
        resultTv.append("\n---------\n")
        val similarityCompare2 = StringCompareHelp.similarityCompare(s1, s3)
        resultTv.append("差异步骤:")
        resultTv.append(similarityCompare2.toString())
        resultTv.append("\n相似度：")
        resultTv.append(StringCompareHelp.similarityStepToScore(similarityCompare2, s1.length, s3.length).toString())

        resultTv.append("\n---------\n")
        val similarityCompare3 = StringCompareHelp.similarityCompare(s0, list)
        resultTv.append("最相似的结果：")
        resultTv.append(similarityCompare3.toString())

        resultTv.append("\n---------\n排序结果：\n")
        val similarityCompareSort = StringCompareHelp.similarityCompareSort(s0, list)
        similarityCompareSort.forEach {
            resultTv.append(it.toString())
            resultTv.append("\n")
        }

    }
}
