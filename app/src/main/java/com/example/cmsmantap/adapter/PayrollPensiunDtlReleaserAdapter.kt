package com.example.cmsmantap.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cmsmantap.R
import com.example.cmsmantap.model.PayrollPensiunRsrDetail


class PayrollPensiunDtlReleaserAdapter (val context: Context):
    RecyclerView.Adapter<PayrollPensiunDtlReleaserAdapter.PayrollPensiunDtlRsrViewHolder>() {
    private val dtlPenList : MutableList<PayrollPensiunRsrDetail> = mutableListOf()


    override fun getItemCount(): Int {
        return dtlPenList.size
    }

    override fun onBindViewHolder(holder: PayrollPensiunDtlReleaserAdapter.PayrollPensiunDtlRsrViewHolder, position: Int) {
        holder.bindmodel(dtlPenList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayrollPensiunDtlReleaserAdapter.PayrollPensiunDtlRsrViewHolder {
        return PayrollPensiunDtlRsrViewHolder(LayoutInflater.from(context).inflate(R.layout.list_detail_validasi_payrollpensiun,parent,false))
    }

    inner class PayrollPensiunDtlRsrViewHolder (item: View): RecyclerView.ViewHolder(item){
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

        fun bindmodel(m: PayrollPensiunRsrDetail) {
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

    fun setListDataPayrollPensiunDtlRsr(data:List<PayrollPensiunRsrDetail>){
        dtlPenList.clear()
        dtlPenList.addAll(data)
        notifyDataSetChanged()
    }
}