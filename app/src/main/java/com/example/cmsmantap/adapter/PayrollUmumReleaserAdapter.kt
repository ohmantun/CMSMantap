package com.example.cmsmantap.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cmsmantap.DetailPayrollUmumCkr
import com.example.cmsmantap.DetailPayrollUmumReleaser
import com.example.cmsmantap.R
import com.example.cmsmantap.model.PayrollUmumChecker
import com.example.cmsmantap.model.PayrollUmumReleaser

class PayrollUmumReleaserAdapter (val context: Context):
    RecyclerView.Adapter<PayrollUmumReleaserAdapter.PayrollUmumReleaserViewHolder>() {
    private val rsr : MutableList<PayrollUmumReleaser> = mutableListOf()

    override fun getItemCount(): Int {
        return rsr.size
    }

    override fun onBindViewHolder(holder: PayrollUmumReleaserAdapter.PayrollUmumReleaserViewHolder, position: Int) {
        holder.bindmodel(rsr[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayrollUmumReleaserViewHolder {
        return PayrollUmumReleaserViewHolder(LayoutInflater.from(context).inflate(R.layout.list_releaser_payrollumum,parent,false))
    }

    inner class PayrollUmumReleaserViewHolder (item: View): RecyclerView.ViewHolder(item){
        val txtnamaFile:TextView = item.findViewById(R.id.tv_fileName)
        val txtTanggalPengajuan:TextView = item.findViewById(R.id.tv_tglPengajuan)
        val txtTanggalEksekusi:TextView = item.findViewById(R.id.tv_tglEksekusi)
        val txtDiajukanOleh:TextView = item.findViewById(R.id.tv_diajukanOleh)
        val txtKeterangan:TextView = item.findViewById(R.id.tv_keterangan)
        //val txtStatus:TextView = item.findViewById(R.id.tv_status)

        val cardViewData: CardView = item.findViewById(R.id.cv_datapayrollumum)
        val btnDetail: Button = item.findViewById(R.id.btnDetail)

        fun bindmodel(m:PayrollUmumReleaser){
            txtnamaFile.text = m.getnamaFile()
            txtTanggalPengajuan.text = m.getTanggalPengajuan()
            txtTanggalEksekusi.text = m.getTanggalEksekusi()
            txtDiajukanOleh.text = m.getDiajukanOleh()
            txtKeterangan.text = m.getKeterangan()
            //txtStatus.text = m.getStatus()

            btnDetail.setOnClickListener{
                var i = Intent(context, DetailPayrollUmumReleaser::class.java)
                context.startActivity(i)
            }
        }
    }

    fun setListDataPayrollUmumReleaser(data:List<PayrollUmumReleaser>){
        rsr.clear()
        rsr.addAll(data)
        notifyDataSetChanged()
    }
}