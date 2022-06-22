package com.alyashafira.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.alyashafira.recyclerview.adapter.AdapterTeamBola
import com.alyashafira.recyclerview.databinding.ActivityMainBinding
import com.alyashafira.recyclerview.model.pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<pemain>()
        listPemain.add(pemain("Thibaut Courtois",R.drawable.img_2, "Penjaga Gawang", "2.00 M","Bree (Belgia)","11 Mei 1980"))
        listPemain.add(pemain("Karim Benzema",R.drawable.img_1, "Penyerang", "1,85 M","Lyon (Perancis)","19 Desember 1980"))
        listPemain.add(pemain("Marcelo Vieira da Silva",R.drawable.img_3, "Belakang", "1.74 M","Rio deJaneiro (Brazil)","11 Mei 1980"))
        listPemain.add(pemain("Sergio Ramos Garcia",R.drawable.img_4, "Belakang", "1.84 M","Camas (Sevilla)","30 Maret 1980"))
        listPemain.add(pemain("Zinedine Yazid Zidane",R.drawable.img, "Pelatih","1.85 M","Marseille (Pranciss)","22 Juni 1980"))

        binding.list.adapter = AdapterTeamBola (this,listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)


                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txt_namapemain)
                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggibadan = this.findViewById<TextView>(R.id.txttinggibadan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnclose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggibadan.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()

            }

        })
    }
}