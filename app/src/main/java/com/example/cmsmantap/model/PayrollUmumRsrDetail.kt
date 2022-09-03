package com.example.cmsmantap.model

class PayrollUmumRsrDetail {
    private var tglTransaksi: String = ""
    private var rekSumber: String = ""
    private var rekPenerima: String = ""
    private var nominal: String = ""
    private var keteranganD: String = ""

    constructor(tglTransaksi: String, rekSumber: String, rekPenerima: String,
                nominal: String, keteranganD: String){

        this.tglTransaksi = tglTransaksi
        this.rekSumber = rekSumber
        this.rekPenerima = rekPenerima
        this.nominal = nominal
        this.keteranganD = keteranganD
    }

    fun getTglTransaksi():String{
        return tglTransaksi
    }

    fun getRekSumber():String{
        return rekSumber
    }

    fun getRekPenerima():String{
        return rekPenerima
    }

    fun getNominal():String{
        return nominal
    }

    fun getKeteranganD():String{
        return keteranganD
    }
}