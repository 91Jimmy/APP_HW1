package com.example.app_hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button2 = findViewById<Button>(R.id.button2)
        val EnterSize = findViewById<EditText>(R.id.EnterSize)
        val EnterColor = findViewById<EditText>(R.id.EnterColor)
        val bundle2 = Bundle()

        intent?.extras?.let{
            val name = it.getString("name")
            val gender = it.getString("gender")

            button2.setOnClickListener {
                if(EnterColor.text.toString().isBlank() || EnterSize.text.toString().isBlank())
                    Toast.makeText(this@MainActivity2, "資料未填寫完整", Toast.LENGTH_SHORT).show()
                else {
                    bundle2.putString("color", EnterColor.text.toString())
                    bundle2.putString("size", EnterSize.text.toString())
                    bundle2.putString("name", name)
                    bundle2.putString("gender", gender)
                    val intent = Intent().putExtras(bundle2)
                    setResult(Activity.RESULT_OK, intent.putExtras(bundle2))
                    finish()
                }
            }
        }
    }
}