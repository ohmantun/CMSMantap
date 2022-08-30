package com.example.cmsmantap.model

import com.example.cmsmantap.fragment.FragmentDaftarTransaksi

class PayrollUmumChecker {
    private var namaFile: String = ""
    private var tanggalPengajuan: String = ""
    private var tanggalEksekusi: String = ""
    private var diajukanOleh: String = ""
    private var keterangan: String = ""
    private var status: String = ""

    constructor(
        namaFile: String, tanggalPengajuan: String, tanggalEksekusi: String, diajukanOleh: String,
        keterangan: String, status: String){
        this.namaFile = namaFile
        this.tanggalPengajuan = tanggalPengajuan
        this.tanggalEksekusi = tanggalEksekusi
        this.diajukanOleh = diajukanOleh
        this.keterangan = keterangan
        this.status = status

    }

    fun getnamaFile():String{
        return namaFile
    }

    fun getTanggalPengajuan():String{
        return tanggalPengajuan
    }

    fun getTanggalEksekusi():String{
        return tanggalEksekusi
    }

    fun getDiajukanOleh():String{
        return diajukanOleh
    }

    fun getKeterangan():String{
        return keterangan
    }

    fun getStatus():String{
        return status
    }

}