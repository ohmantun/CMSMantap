package com.example.cmsmantap.ui

import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cmsmantap.DetailPayrollUmumCkr
import com.example.cmsmantap.DetailPayrollUmumReleaser
import com.example.cmsmantap.R
import com.example.cmsmantap.data.MakerModel
import kotlinx.android.synthetic.main.fragment_daftartransaksi_checker_cardview.view.*
import kotlinx.android.synthetic.main.fragment_daftartransaksi_releaser_cardview.view.*

class ReleaserAdapter(var listener:HomeListener) : RecyclerView.Adapter<ReleaserAdapter.HomeViewHolder>(){

    private var data : ArrayList<MakerModel>?=null

    interface HomeListener{
        //fun onItemDeleted(MakerModel: MakerModel, position: Int)
    }

    fun setData(list: ArrayList<MakerModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_daftartransaksi_releaser_cardview, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
        holder.itemView.btnDetailReleaser.setOnClickListener {
            item?.let { it1 ->
                // bikin intent baru untuk ek activity detail
                val intent = Intent(holder.itemView.context, DetailPayrollUmumReleaser::class.java)
                intent.putExtra("id",it1.payroll_id)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: MakerModel?) {
            if (item?.status_checker == "Approved by Checker"){
                itemView.tv_infoStatusUmumReleaser.text = "Menunggu Persetujuan Releaser"
                itemView.tv_cardInfoStatusUmumReleaser.setCardBackgroundColor(Color.parseColor("#F9C70C"))
            } else if (item?.status_checker == "Approved") {
                itemView.tv_infoStatusUmumReleaser.text = "Telah Disetujui"
                itemView.tv_cardInfoStatusUmumReleaser.setCardBackgroundColor(Color.parseColor("#00AD43"))
            } else if (item?.status_checker == "Rejected") {
                itemView.tv_infoStatusUmumReleaser.text = "Belum Disetujui"
                itemView.tv_cardInfoStatusUmumReleaser.setCardBackgroundColor(Color.parseColor("#B22222"))
            } else {
                itemView.tv_infoStatusUmumReleaser.text = "Menunggu Diproses"
                itemView.tv_cardInfoStatusUmumReleaser.setCardBackgroundColor(Color.parseColor("#F9C70C"))
            }
            itemView.tv_tanggal_pengajuan_releaser.text = item?.tanggal_pengajuan
            itemView.tv_tanggal_eksekusi_releaser.text = item?.tanggal_eksekusi
            itemView.tv_diajukan_oleh_releaser.text = item?.maker
            itemView.tv_keterangan_releaser.text = item?.keterangan
        }

    }

}