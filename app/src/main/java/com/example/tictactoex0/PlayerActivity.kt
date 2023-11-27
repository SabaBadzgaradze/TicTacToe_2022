package com.example.tictactoex0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class PlayerActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var buttonBack: ImageView

    private lateinit var playerOne: EditText
    private lateinit var playerTwo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)



        init()
        startActivity()


    }

    private fun init() {
        button = findViewById(R.id.button)
        buttonBack = findViewById(R.id.buttonBack)

        playerOne = findViewById(R.id.playerOne)
        playerTwo = findViewById(R.id.playerTwo)

    }

    private fun startActivity() {

        button.setOnClickListener {


            if (playerOne.text.isNotEmpty() && playerTwo.text.isNotEmpty()){

                val intent = Intent(this,GameActivity::class.java)

                intent.putExtra("NameOne", playerOne.text.toString())
                intent.putExtra("NameTwo", playerTwo.text.toString())

                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this, "Add Names", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        buttonBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}