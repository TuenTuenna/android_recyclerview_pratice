package com.jeongdaeri.myrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(myRecyclerviewInterface: MyRecyclerviewInterface): RecyclerView.Adapter<MyViewHolder>() {

    val TAG: String = "로그"

    private var modelList = ArrayList<MyModel>()

    private var myRecyclerviewInterface :MyRecyclerviewInterface? = null

    // 생성자
    init {
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }

    // 뷰홀더가 생성 되었을때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // 연결할 레이아웃 설정

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false), this.myRecyclerviewInterface!!)
    }

    // 목록의 아이템수
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    // 뷰와 뷰홀더가 묶였을때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position: $position")
        holder.bind(this.modelList[position])

    }

    // 외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }

}
