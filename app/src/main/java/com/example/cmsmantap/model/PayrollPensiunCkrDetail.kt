package com.example.cmsmantap.model

class PayrollPensiunCkrDetail {

    private var nmrPensiun: String = ""
    private var nmrRekening: String = ""
    private var nama: String = ""
    private var nilaiGaji: String = ""
    private var keterangan: String = ""
    private var statusBlokir: String = ""
    private var tglDapem: String = ""
    private var tglEfektif: String = ""


    constructor(nmrPensiun: String, nmrRekening: String, nama: String,
                nilaiGaji: String, keterangan: String, statusBlokir: String,
                tglDapem: String, tglEfektif: String,){

        this.nmrPensiun = nmrPensiun
        this.nmrRekening = nmrRekening
        this.nama = nama
        this.nilaiGaji = nilaiGaji
        this.keterangan = keterangan
        this.statusBlokir = statusBlokir
        this.tglDapem = tglDapem
        this.tglEfektif = tglEfektif
    }

    fun getNmrPensiun():String{
        return nmrPensiun
    }

    fun getNmrRekening():String{
        return nmrRekening
    }

    fun getNama():String{
        return nama
    }

    fun getNilaiGaji():String{
        return nilaiGaji
    }

    fun getKeterangan():String{
        return keterangan
    }

    fun getStatusBlokir():String{
        return statusBlokir
    }

    fun getTglDapem():String{
        return tglDapem
    }

    fun getTglEfektif():String{
        return tglEfektif
    }
}