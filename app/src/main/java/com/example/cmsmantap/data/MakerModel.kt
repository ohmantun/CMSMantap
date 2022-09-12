package com.example.cmsmantap.data

data class MakerModel(
    var payroll_id:Int?=0,
    var nomor_rekening:Int?=0,
    var jenis_rekening:String?="",
    var nama_rekening:String?="",
    var nominal:Int?=0,
    var keterangan:String?="",
    var tanggal_pengajuan:String?="",
    var tanggal_eksekusi:String?="",
    var maker:String?="",
    var status_maker:String?="",
    var status_checker:String?="",
    var status_releaser:String?="",
    var transaksi_id:Int?=0,
    var karyawan_id:Int?=0
)