package com.example.cmsmantap.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cmsmantap.DetailPayrollPensiunCkr
import com.example.cmsmantap.R
import com.example.cmsmantap.model.PayrollPensiunCkrDetail
import com.example.cmsmantap.model.PayrollUmumCkrDetail

class PayrollPensiunDtlCkrAdapter (val context: Context):
    RecyclerView.Adapter<PayrollPensiunDtlCkrAdapter.PayrollPensiunDtlCkrViewHolder>() {
    private val dtlPenList : MutableList<PayrollPensiunCkrDetail> = mutableListOf()


    override fun getItemCount(): Int {
        return dtlPenList.size
    }

    override fun onBindViewHolder(holder: PayrollPensiunDtlCkrAdapter.PayrollPensiunDtlCkrViewHolder, position: Int) {
        holder.bindmodel(dtlPenList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayrollPensiunDtlCkrAdapter.PayrollPensiunDtlCkrViewHolder {
        return PayrollPensiunDtlCkrViewHolder(LayoutInflater.from(context).inflate(R.layout.list_detail_validasi_payrollpensiun,parent,false))
    }

    inner class PayrollPensiunDtlCkrViewHolder (item: View): RecyclerView.ViewHolder(item){
        val txtNmrPensiun: TextView = item.findViewById(R.id.tv_nmrPensiun)
        val txtNmrRekening: TextView = item.findViewById(R.id.tv_nmrRekening)
        val txtNama: TextView = item.findViewById(R.id.tv_nama)
        val txtNilaiGaji: TextView = item.findViewById(R.id.tv_nilaiGaji)
        val txtKeterangan: TextView = item.findViewById(R.id.tv_keteranganPen)
        val txtStatusBlokir: TextView = item.findViewById(R.id.tv_statusBlokir)
        val txtTglDapem: TextView = item.findViewById(R.id.tv_tglDapem)
        val txtTglEfektif: TextView = item.findViewById(R.id.tv_tglEfektif)

        //val cardViewData: CardView = item.findViewById(R.id.cv_detaildatapayrollumum)
        //val btnDetail: Button = item.findViewById(R.id.btnDetail)

        fun bindmodel(m: PayrollPensiunCkrDetail) {
            txtNmrPensiun.text = m.getNmrPensiun()
            txtNmrRekening.text = m.getNmrRekening()
            txtNama.text = m.getNama()
            txtNilaiGaji.text = m.getNilaiGaji()
            txtKeterangan.text = m.getKeterangan()
            txtStatusBlokir.text = m.getStatusBlokir()
            txtTglDapem.text = m.getTglDapem()
            txtTglEfektif.text = m.getTglEfektif()

        }
    }

    fun setListDataPayrollPensiunDtlCkr(data:List<PayrollPensiunCkrDetail>){
        dtlPenList.clear()
        dtlPenList.addAll(data)
        notifyDataSetChanged()
    }
}