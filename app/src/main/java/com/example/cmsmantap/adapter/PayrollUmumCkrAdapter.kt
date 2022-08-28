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
import com.example.cmsmantap.R
import com.example.cmsmantap.model.PayrollUmumChecker

class PayrollUmumCkrAdapter (val context: Context):
    RecyclerView.Adapter<PayrollUmumCkrAdapter.PayrollUmumCkrViewHolder>() {
    private val ckr : MutableList<PayrollUmumChecker> = mutableListOf()

    override fun getItemCount(): Int {
        return ckr.size
    }

    override fun onBindViewHolder(holder: PayrollUmumCkrAdapter.PayrollUmumCkrViewHolder, position: Int) {
        holder.bindmodel(ckr[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayrollUmumCkrViewHolder {
        return PayrollUmumCkrViewHolder(LayoutInflater.from(context).inflate(R.layout.list_validasi_payrollumum,parent,false))
    }

    inner class PayrollUmumCkrViewHolder (item: View): RecyclerView.ViewHolder(item){
        val txtnamaFile:TextView = item.findViewById(R.id.tv_fileName)
        val txtTanggalPengajuan:TextView = item.findViewById(R.id.tv_tglPengajuan)
        val txtTanggalEksekusi:TextView = item.findViewById(R.id.tv_tglEksekusi)
        val txtDiajukanOleh:TextView = item.findViewById(R.id.tv_diajukanOleh)
        val txtKeterangan:TextView = item.findViewById(R.id.tv_keterangan)
        val txtStatus:TextView = item.findViewById(R.id.tv_status)

        val cardViewData: CardView = item.findViewById(R.id.cv_datapayrollumum)
        val btnDetail: Button = item.findViewById(R.id.btnDetail)

        fun bindmodel(m:PayrollUmumChecker){
            txtnamaFile.text = m.getnamaFile()
            txtTanggalPengajuan.text = m.getTanggalPengajuan()
            txtTanggalEksekusi.text = m.getTanggalEksekusi()
            txtDiajukanOleh.text = m.getDiajukanOleh()
            txtKeterangan.text = m.getKeterangan()
            txtStatus.text = m.getStatus()

            btnDetail.setOnClickListener{
                var i = Intent(context, DetailPayrollUmumCkr::class.java)
                context.startActivity(i)
            }
        }

    }

    fun setListDataPayrollUmumCkr(data:List<PayrollUmumChecker>){
        ckr.clear()
        ckr.addAll(data)
        notifyDataSetChanged()
    }

}