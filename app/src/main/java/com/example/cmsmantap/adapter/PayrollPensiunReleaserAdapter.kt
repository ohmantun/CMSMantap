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
import com.example.cmsmantap.DetailPayrollPensiunReleaser
import com.example.cmsmantap.R
import com.example.cmsmantap.model.PayrollPensiunReleaser


class PayrollPensiunReleaserAdapter (val context: Context):
    RecyclerView.Adapter<PayrollPensiunReleaserAdapter.PayrollPensiunRsrViewHolder>() {
    private val rsrList : MutableList<PayrollPensiunReleaser> = mutableListOf()

    override fun getItemCount(): Int {
        return rsrList.size
    }

    override fun onBindViewHolder(holder: PayrollPensiunReleaserAdapter.PayrollPensiunRsrViewHolder, position: Int) {
        holder.bindmodel(rsrList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayrollPensiunReleaserAdapter.PayrollPensiunRsrViewHolder {
        return PayrollPensiunRsrViewHolder(LayoutInflater.from(context).inflate(R.layout.list_releaser_payrollpensiun,parent,false))
    }

    inner class PayrollPensiunRsrViewHolder (item: View): RecyclerView.ViewHolder(item){
        val txtnamaFile: TextView = item.findViewById(R.id.tv_fileName)
        val txtProses: TextView = item.findViewById(R.id.tv_proses)
        val txtRekeningSumber: TextView = item.findViewById(R.id.tv_rekSumberPen)
        val txtDiajukanOleh: TextView = item.findViewById(R.id.tv_diajukanOlehPen)
        val txtJadwalTransaksi: TextView = item.findViewById(R.id.tv_jadwalTransaksi)
        //val txtStatus: TextView = item.findViewById(R.id.tv_statusPen)

        val cardViewData: CardView = item.findViewById(R.id.cv_datapayrollpensiun)
        val btnDetailPen: Button = item.findViewById(R.id.btnDetailPen)

        fun bindmodel(m: PayrollPensiunReleaser){
            txtnamaFile.text = m.getnamaFile()
            txtProses.text = m.getProses()
            txtRekeningSumber.text = m.getRekeningSumber()
            txtDiajukanOleh.text = m.getDiajukanOleh()
            txtJadwalTransaksi.text = m.getJadwalTransaksi()
            //txtStatus.text = m.getStatus()

            btnDetailPen.setOnClickListener {
                var intent = Intent(context, DetailPayrollPensiunReleaser::class.java)
                context.startActivity(intent)
            }

        }

    }

    fun setListDataPayrollPensiunRsr(data:List<PayrollPensiunReleaser>){
        rsrList.clear()
        rsrList.addAll(data)
        notifyDataSetChanged()
    }
}