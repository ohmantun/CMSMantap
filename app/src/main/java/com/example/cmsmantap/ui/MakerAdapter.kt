package com.example.cmsmantap.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cmsmantap.R
import com.example.cmsmantap.data.MakerModel
import kotlinx.android.synthetic.main.fragment_daftartransaksi_cardview.view.*

class MakerAdapter(var listener:HomeListener) : RecyclerView.Adapter<MakerAdapter.HomeViewHolder>(){

    private var data : ArrayList<MakerModel>?=null

    interface HomeListener{
        //fun onItemDeleted(MakerModel: MakerModel, position: Int)
    }

    fun setData(list: ArrayList<MakerModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_daftartransaksi_cardview, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
//        holder.itemView.img_delete.setOnClickListener {
//            item?.let { it1 ->
//                listener.onItemDeleted(it1, position)
//            }
//        }
    }

    fun addData(MakerModel: MakerModel) {
        data?.add(0,MakerModel)
        notifyItemInserted(0)
    }

    fun removeData(position: Int) {
        data?.removeAt(position)
        notifyDataSetChanged()
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: MakerModel?) {
            itemView.tv_tanggal_pengajuan.text = item?.tanggal_pengajuan
            itemView.tv_tanggal_eksekusi.text = item?.tanggal_eksekusi
            itemView.tv_diajukan_oleh.text = item?.maker
            itemView.tv_jadwal_transaksi.text = item?.tanggal_eksekusi
        }

    }

}