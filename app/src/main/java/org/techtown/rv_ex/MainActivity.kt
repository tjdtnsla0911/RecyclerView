package org.techtown.rv_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = mutableListOf<String>()

        for(i in 1..20){
            items.add(i.toString())
        }
        //리사이클러뷰를 가져온다
        val rv = findViewById<RecyclerView>(R.id.rv)

        val rvAdapter = RVAdapter(items)
        //adapter에 주입한다
        rv.adapter = rvAdapter
        //리사이클러뷰는 한줄더추가해야함
        rv.layoutManager = LinearLayoutManager(this)
//        rv.layoutManager = LinearLayoutManager(this).also {
//            //가로로 그리기
//            it.orientation = LinearLayoutManager.HORIZONTAL
//        }

        rvAdapter.itemClick = object : RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                //여기선 baseContext를 써야함
                Toast.makeText(baseContext,items[position],Toast.LENGTH_SHORT).show()
            }
        }



    }
}