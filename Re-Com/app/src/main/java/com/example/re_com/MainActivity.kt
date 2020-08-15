package com.example.re_com

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //親要素のリスト
        val parts: MutableList<String> = ArrayList()
        parts.add("CPU")
        parts.add("グラフィックボード")
        parts.add("メモリ")

        //子要素のリスト
        val explains_cpu: MutableList<String> = ArrayList()
        explains_cpu.add("CROWN")
        val explains_gpu: MutableList<String> = ArrayList()//gpu = グラフィックボード
        explains_gpu.add("ATENZA")
        val explains_memory: MutableList<String> = ArrayList()
        explains_memory.add("LEGEND")


        val explains: MutableList<List<String>> = ArrayList()
        explains.add(explains_cpu)
        explains.add(explains_gpu)
        explains.add(explains_memory)

        //ExpandableListViewの初期化
        val exListView = findViewById<ExpandableListView>(R.id.exlistview)
        val adapter = ExplainsPartsListAdapter(this, parts, explains)
        exListView.setAdapter(adapter)
        exListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id -> //子要素をタップした時の処理
            //このサンプルではToastメッセージを表示するだけ
            val adapter1 = parent.expandableListAdapter as ExplainsPartsListAdapter
            val partsname = adapter1.getGroup(groupPosition) as String //親要素からメーカー名を取得
            val carname = adapter1.getChild(groupPosition, childPosition) as String //子要素から車名を取得
            Toast.makeText(applicationContext, "$partsname : $carname", Toast.LENGTH_LONG).show() //Toast生成
            true
        }
    }

    internal inner class ExplainsPartsListAdapter(context: Context, listParts: List<String>, listExplains: List<List<String>>) : BaseExpandableListAdapter() {
        //メンバ変数
        var listParts //親要素のリスト
                : List<String>
        var listExplains //子要素のリスト
                : List<List<String>>
        var context: Context
        override fun getGroupCount(): Int {
            return listParts.size //親要素の数を返す
        }

        override fun getChildrenCount(groupPosition: Int): Int {
            return listExplains[groupPosition].size //子要素の数を返す
        }

        override fun getGroup(groupPosition: Int): Any {
            return listParts[groupPosition] //親要素を取得
        }

        override fun getChild(groupPosition: Int, childPosition: Int): Any {
            return listExplains[groupPosition][childPosition] //子要素を取得
        }

        override fun getGroupId(groupPosition: Int): Long {
            //親要素の固有IDを返す
            //このサンプルでは固有IDは無いので0
            return 0
        }

        override fun getChildId(groupPosition: Int, childPosition: Int): Long {
            //子要素の固有IDを返す
            //このサンプルでは固有IDは無いので0
            return 0
        }

        override fun hasStableIds(): Boolean {
            //固有IDを持つかどうかを返す
            //このサンプルでは持たないのでfalse
            return false
        }

        override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
            //親要素のレイアウト生成
            var convertView: View? = convertView
            if (convertView == null) {
                val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                convertView = inflater.inflate(R.layout.listitem_parts, parent, false)
            }
            val tv: TextView = convertView!!.findViewById(R.id.listitem_parts_name)
            tv.text = listParts[groupPosition]
            return convertView
        }

        override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
            //子要素のレイアウト生成
            var convertView: View? = convertView
            if (convertView == null) {
                val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                convertView = inflater.inflate(R.layout.listitem_explains, parent, false)
            }
            val tv: TextView = convertView!!.findViewById(R.id.listitem_explains_sentences)
            tv.text = listExplains[groupPosition][childPosition]
            return convertView
        }

        override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
            //子要素がタップ可能かどうかを返す
            //このサンプルでは可能にするのでtrue
            return true
        }

        //コンストラクタ
        init {
            this.context = context
            this.listParts = listParts
            this.listExplains = listExplains
        }
    }
}