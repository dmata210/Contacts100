package com.example.contacts100

import android.Manifest
import android.annotation.SuppressLint

import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.InputStream
import java.lang.Exception
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.example.contacts100.databinding.ActivityMainBinding

//import com.github.doyaaaaaken.kotlincsv.dsl.csvReader


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val EXTERNAL_STORAGE_PERMISSION_CODE = 23
    @SuppressLint("Range")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.MANAGE_EXTERNAL_STORAGE),
            EXTERNAL_STORAGE_PERMISSION_CODE
        )


        setContentView(binding.root)

        val folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(folder, "100-contacts.csv")
        val db = DBhelper(this, null)
        val inputStream: InputStream = file.inputStream()
        val lines = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { lines.add(it) }
        lines.removeAt(0)
        lines.forEach{ db.addLine(it) }

        binding.buttoncheck.setOnClickListener{
/*            val db = DBhelper(this, null)
            val idname = binding.idpull.text.toString()
            val result = db.getLine(idname)
            binding.displayinfo.text = result.toString()*/

            try{
                val num: String = binding.idpull.text.toString()
                if (checkFields( num.toInt() )  ){
                    val cursor = db.getLine(num)
                    cursor!!.moveToFirst()
                    binding.displayinfo.setText(CursorToString.returnString(cursor))
                } else{
                    Toast.makeText(this, "Enter number between 1 and 99", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception){
                    Log.e("AndroidKotlin App Error",e.toString())
            }


        }

    }

}

private fun checkFields(number:Int) :Boolean{

    val regex = Regex("\\b([1-9]|[1-9][0-9])\\b")

    return regex.matches(number.toString())
}

