package com.example.app_hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = Bundle()
        val button1 = findViewById<Button>(R.id.button1)
        val EnterName = findViewById<EditText>(R.id.EnterName)
        val EnterGender = findViewById<EditText>(R.id.EnterGender)


        button1.setOnClickListener {
            if(EnterName.text.toString().isBlank() || EnterGender.text.toString().isBlank())
                Toast.makeText(this@MainActivity, "資料未填寫完整", Toast.LENGTH_SHORT).show()
            else {
                bundle.putString("name", EnterName.text.toString())
                bundle.putString("gender", EnterGender.text.toString())
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtras(bundle)
                startActivityForResult(intent, 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let{
            if (requestCode == 1 && resultCode == RESULT_OK){
                findViewById<TextView>(R.id.YourName).text = "您的姓名：${it.getString("name")}"
                findViewById<TextView>(R.id.YourGender).text = "您的性別：${it.getString("gender")}"
                findViewById<TextView>(R.id.Color).text = "您的衣服顏色：${it.getString("color")}"
                findViewById<TextView>(R.id.Size).text = "您的衣服尺寸：${it.getString("size")}"
            }
        }
    }
}