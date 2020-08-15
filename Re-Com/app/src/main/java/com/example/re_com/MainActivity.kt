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
        val partsArray: Array<String> = resources.getStringArray(R.array.parts_array)
        for(partsName in partsArray){
            parts.add(partsName)
        }

        //子要素のリスト
        val explainsOs: MutableList<String> = ArrayList()
        explainsOs.add(getString(R.string.ex_os))
        val explainsCpu: MutableList<String> = ArrayList()
        explainsCpu.add(getString(R.string.ex_cpu))
        val explainsGpu: MutableList<String> = ArrayList()//gpu = グラフィックボード
        explainsGpu.add(getString(R.string.ex_gpu))
        val explainsMemory: MutableList<String> = ArrayList()
        explainsMemory.add(getString(R.string.ex_memory))
        val explainsSsd: MutableList<String> = ArrayList()
        explainsSsd.add(getString(R.string.ex_ssd))
        val explainsHdd: MutableList<String> = ArrayList()
        explainsHdd.add(getString(R.string.ex_hdd))
        val explainsMother: MutableList<String> = ArrayList()
        explainsMother.add(getString(R.string.ex_mother))
        val explainsPower: MutableList<String> = ArrayList()
        explainsPower.add(getString(R.string.ex_power))

        val explains: MutableList<List<String>> = ArrayList()
        explains.add(explainsOs)
        explains.add(explainsCpu)
        explains.add(explainsGpu)
        explains.add(explainsMemory)
        explains.add(explainsSsd)
        explains.add(explainsHdd)
        explains.add(explainsMother)
        explains.add(explainsPower)

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
            //固有IDは無いので0
            return 0
        }

        override fun getChildId(groupPosition: Int, childPosition: Int): Long {
            //子要素の固有IDを返す
            //固有IDは無いので0
            return 0
        }

        override fun hasStableIds(): Boolean {
            //固有IDを持つかどうかを返す
            //持たないのでfalse
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