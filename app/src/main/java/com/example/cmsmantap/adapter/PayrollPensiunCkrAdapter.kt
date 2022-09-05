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
import com.example.cmsmantap.DetailPayrollPensiunCkr
import com.example.cmsmantap.R
import com.example.cmsmantap.model.PayrollPensiunCkr


class PayrollPensiunCkrAdapter (val context: Context):
    RecyclerView.Adapter<PayrollPensiunCkrAdapter.PayrollPensiunCkrViewHolder>() {
    private val pensiunList : MutableList<PayrollPensiunCkr> = mutableListOf()

    override fun getItemCount(): Int {
        return pensiunList.size
    }

    override fun onBindViewHolder(holder: PayrollPensiunCkrAdapter.PayrollPensiunCkrViewHolder, position: Int) {
        holder.bindmodel(pensiunList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayrollPensiunCkrAdapter.PayrollPensiunCkrViewHolder {
        return PayrollPensiunCkrViewHolder(LayoutInflater.from(context).inflate(R.layout.list_validasi_payrollpensiun,parent,false))
    }

    inner class PayrollPensiunCkrViewHolder (item: View): RecyclerView.ViewHolder(item){
        val txtnamaFile: TextView = item.findViewById(R.id.tv_fileName)
        val txtProses: TextView = item.findViewById(R.id.tv_proses)
        val txtRekeningSumber: TextView = item.findViewById(R.id.tv_rekSumberPen)
        val txtDiajukanOleh: TextView = item.findViewById(R.id.tv_diajukanOlehPen)
        val txtJadwalTransaksi: TextView = item.findViewById(R.id.tv_jadwalTransaksi)
        //val txtStatus: TextView = item.findViewById(R.id.tv_statusPen)

        val cardViewData: CardView = item.findViewById(R.id.cv_datapayrollpensiun)
        val btnDetailPen: CardView = item.findViewById(R.id.btnDetailPen)

        fun bindmodel(m: PayrollPensiunCkr){
            txtnamaFile.text = m.getnamaFile()
            txtProses.text = m.getProses()
            txtRekeningSumber.text = m.getRekeningSumber()
            txtDiajukanOleh.text = m.getDiajukanOleh()
            txtJadwalTransaksi.text = m.getJadwalTransaksi()
            //txtStatus.text = m.getStatus()

            btnDetailPen.setOnClickListener {
                var intent = Intent(context, DetailPayrollPensiunCkr::class.java)
                context.startActivity(intent)
            }

        }

    }

    fun setListDataPayrollPensiunCkr(data:List<PayrollPensiunCkr>){
        pensiunList.clear()
        pensiunList.addAll(data)
        notifyDataSetChanged()
    }
}