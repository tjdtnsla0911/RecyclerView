package org.techtown.rv_ex

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(var items : MutableList<String>) :  RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    //리사이클러뷰의 아이템을 불러온다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {

        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(view)

    }
    //온클릭쓸꺼면 이런식으로해야함
    interface ItemClick{
        fun onClick(view : View,position: Int)
    }

    var itemClick : ItemClick? = null

    //여기에 바인딩해준다
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        if(itemClick != null){
            holder.itemView.setOnClickListener{v->
                itemClick?.onClick(v,position)
            }
        }
     //항목이일로간다.
        holder.bindItems(items[position])
    }
    //전체 리사이클러뷰의 개수
    override fun getItemCount(): Int {
        return items.size
    }
    inner class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

        fun bindItems(item : String){
            //여기서 넣어줘야 반영댐
            val re_text = itemView.findViewById<TextView>(R.id.rv_items)
            Log.e("######ViewHolder 에어옴 ","아이템 = "+re_text.text)
            re_text.text =  item
        }
    }
}