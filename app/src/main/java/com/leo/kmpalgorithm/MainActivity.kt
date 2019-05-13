package com.leo.kmpalgorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.leo.strmatchlib.StringCompareHelp

class MainActivity : AppCompatActivity() {
    private lateinit var mResultTv: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mResultTv = findViewById(R.id.resultTv)
        val s0 = "鞋子不能在实体店买"
        val s1 = "鞋子不能在店里买"
        val s2 = "不能在实体店买鞋"
        val s3 = "鞋子不能在实体店买"
        val s4 = "鞋子不能在实体买"
        val similarityCompare = StringCompareHelp.similarityCompare(s1, s2)
        mResultTv.text = "差异步骤:"
        mResultTv.append(similarityCompare.toString())
        mResultTv.append("\n相似度：")
        mResultTv.append(StringCompareHelp.similarityStepToScore(similarityCompare, s1.length, s2.length).toString())
        mResultTv.append("\n---------\n")
        val similarityCompare2 = StringCompareHelp.similarityCompare(s1, s3)
        mResultTv.append("差异步骤:")
        mResultTv.append(similarityCompare2.toString())
        mResultTv.append("\n相似度：")
        mResultTv.append(StringCompareHelp.similarityStepToScore(similarityCompare2, s1.length, s3.length).toString())

        mResultTv.append("\n---------\n")
        val list = listOf(s1, s2, s3, s4)
        val similarityCompare3 = StringCompareHelp.similarityCompare(s0, list)
        mResultTv.text = "最相似的结果："
        mResultTv.append(similarityCompare3)
    }
}
