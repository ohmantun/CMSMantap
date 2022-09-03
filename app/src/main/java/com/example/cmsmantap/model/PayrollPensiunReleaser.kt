package com.example.cmsmantap.model

class PayrollPensiunReleaser {

    private var namaFile: String = ""
    private var proses: String = ""
    private var rekeningSumber: String = ""
    private var diajukanOleh: String = ""
    private var jadwalTransaksi: String = ""
    private var status: String = ""

    constructor(
        namaFile: String, proses: String, rekeningSumber: String, diajukanOleh: String,
        jadwalTransaksi: String, status: String){
        this.namaFile = namaFile
        this.proses = proses
        this.rekeningSumber = rekeningSumber
        this.diajukanOleh = diajukanOleh
        this.jadwalTransaksi = jadwalTransaksi
        this.status = status

    }

    fun getnamaFile():String{
        return namaFile
    }

    fun getProses():String{
        return proses
    }

    fun getRekeningSumber():String{
        return rekeningSumber
    }

    fun getDiajukanOleh():String{
        return diajukanOleh
    }

    fun getJadwalTransaksi():String{
        return jadwalTransaksi
    }

    fun getStatus():String{
        return status
    }
}