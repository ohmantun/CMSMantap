package com.example.cmsmantap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cmsmantap.R
import com.example.cmsmantap.model.PayrollUmumCkrDetail

class PayrollUmumDCkrAdapter (val context: Context):
    RecyclerView.Adapter<PayrollUmumDCkrAdapter.PayrollUmumDCkrViewHolder>() {
    private val ckrD : MutableList<PayrollUmumCkrDetail> = mutableListOf()

    override fun getItemCount(): Int {
        return ckrD.size
    }

    override fun onBindViewHolder(holder: PayrollUmumDCkrAdapter.PayrollUmumDCkrViewHolder, position: Int) {
        holder.bindmodel(ckrD[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayrollUmumDCkrAdapter.PayrollUmumDCkrViewHolder {
        return PayrollUmumDCkrViewHolder(LayoutInflater.from(context).inflate(R.layout.list_detail_validasi_payrollumum,parent,false))
    }

    inner class PayrollUmumDCkrViewHolder (item: View): RecyclerView.ViewHolder(item){
        val txtTglTransaksi: TextView = item.findViewById(R.id.tv_tglTransaksi)
        val txtRekSumber: TextView = item.findViewById(R.id.tv_rekSumber)
        val txtRekPenerima: TextView = item.findViewById(R.id.tv_rekPenerima)
        val txtNominal: TextView = item.findViewById(R.id.tv_nominal)
        val txtKeteranganD: TextView = item.findViewById(R.id.tv_detailKeterangan)

        //val cardViewData: CardView = item.findViewById(R.id.cv_detaildatapayrollumum)

        fun bindmodel(m: PayrollUmumCkrDetail) {
            txtTglTransaksi.text = m.getTglTransaksi()
            txtRekSumber.text = m.getRekSumber()
            txtRekPenerima.text = m.getRekPenerima()
            txtNominal.text = m.getNominal()
            txtKeteranganD.text = m.getKeteranganD()

        }
    }

    fun setListDataPayrollUmumDCkr(data:List<PayrollUmumCkrDetail>){
        ckrD.clear()
        ckrD.addAll(data)
        notifyDataSetChanged()
    }
}