package com.example.tictactoex0

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class GameActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var line123: ImageView
    private lateinit var line456: ImageView
    private lateinit var line789: ImageView
    private lateinit var line147: ImageView
    private lateinit var line258: ImageView
    private lateinit var line369: ImageView
    private lateinit var line159: ImageView
    private lateinit var line357: ImageView

    private lateinit var buttonBack: ImageView

    private lateinit var player1: TextView
    private lateinit var player2: TextView

    private lateinit var playerOne: TextView
    private lateinit var playerTwo: TextView

    private lateinit var resetButton: Button

    private var score1:Int = 0
    private var score2:Int = 0

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        init()

        startActivity()

        resetButton = findViewById(R.id.resetButton)
        resetButton.setOnClickListener{
            reset(activePlayer)
        }

        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)

        val intent = getIntent()
        val nameOne = intent.getStringExtra("NameOne")
        val nameTwo = intent.getStringExtra("NameTwo")

        playerOne.text = "$nameOne"
        playerTwo.text = "$nameTwo"

    }

    private fun init() {
        button1= findViewById(R.id.button1)
        button2= findViewById(R.id.button2)
        button3= findViewById(R.id.button3)
        button4= findViewById(R.id.button4)
        button5= findViewById(R.id.button5)
        button6= findViewById(R.id.button6)
        button7= findViewById(R.id.button7)
        button8= findViewById(R.id.button8)
        button9= findViewById(R.id.button9)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        buttonBack = findViewById(R.id.buttonBack)

        playerOne = findViewById(R.id.playerOne)
        playerTwo = findViewById(R.id.playerTwo)

        line123 = findViewById(R.id.line123)
        line456 = findViewById(R.id.line456)
        line789 = findViewById(R.id.line789)
        line147 = findViewById(R.id.line147)
        line258 = findViewById(R.id.line258)
        line369 = findViewById(R.id.line369)
        line159 = findViewById(R.id.line159)
        line357 = findViewById(R.id.line357)


    }

    private fun startActivity() {
        buttonBack.setOnClickListener {
            val intent = Intent(this,PlayerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }

            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1 ) {

            clickedView.text = "X"
            clickedView.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            firstPlayer.add(buttonNumber)

            activePlayer = 2

        }else{

            clickedView.text = "O"
            clickedView.setTextColor(resources.getColor(android.R.color.holo_blue_dark))
            secondPlayer.add(buttonNumber)

            activePlayer = 1
        }

        clickedView.isEnabled = false

        check()
    }

    private fun reset(winner: Int){

        button1.text=""
        button2.text=""
        button3.text=""
        button4.text=""
        button5.text=""
        button6.text=""
        button7.text=""
        button8.text=""
        button9.text=""

        button1.isEnabled=true
        button2.isEnabled=true
        button3.isEnabled=true
        button4.isEnabled=true
        button5.isEnabled=true
        button6.isEnabled=true
        button7.isEnabled=true
        button8.isEnabled=true
        button9.isEnabled=true

        line123.alpha = 0F
        line456.alpha = 0F
        line789.alpha = 0F
        line147.alpha = 0F
        line258.alpha = 0F
        line369.alpha = 0F
        line159.alpha = 0F
        line357.alpha = 0F

        button1.isClickable = true
        button2.isClickable = true
        button3.isClickable = true
        button4.isClickable = true
        button5.isClickable = true
        button6.isClickable = true
        button7.isClickable = true
        button8.isClickable = true
        button9.isClickable = true



        firstPlayer.clear()
        secondPlayer.clear()

        activePlayer = winner




    }


    private fun check() {
        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {

            line123.animate().alpha(1F).duration = 200

            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {

            line123.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {

            line456.animate().alpha(1F).duration = 200

            winnerPlayer = 1

        }

        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {

            line456.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {

            line789.animate().alpha(1F).duration = 200

            winnerPlayer = 1

        }

        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {

            line789.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {

            line147.animate().alpha(1F).duration = 200

            winnerPlayer = 1

        }

        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {

            line147.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {

            line258.animate().alpha(1F).duration = 200

            winnerPlayer = 1

        }

        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {

            line258.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {

            line369.animate().alpha(1F).duration = 200

            winnerPlayer = 1

        }

        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {

            line369.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {

            line159.animate().alpha(1F).duration = 200

            winnerPlayer = 1

        }

        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {

            line159.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {

            line357.animate().alpha(1F).duration = 200

            winnerPlayer = 1

        }

        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {

            line357.animate().alpha(1F).duration = 200

            winnerPlayer = 2

        }

        if (winnerPlayer == 1) {

            val intent = intent
            val nameOne = intent.getStringExtra("NameOne")

            Toast.makeText(this, "$nameOne Won", Toast.LENGTH_SHORT).show()
            score1++
            player1.text = "$score1"
            button1.isClickable= false
            button2.isClickable= false
            button3.isClickable= false
            button4.isClickable= false
            button5.isClickable= false
            button6.isClickable= false
            button7.isClickable= false
            button8.isClickable= false
            button9.isClickable= false
            Handler().postDelayed({
                                  reset(1)
            }, 1000)

        }else if (winnerPlayer == 2){

            val intent = intent
            val nameTwo = intent.getStringExtra("NameTwo")

            Toast.makeText(this, "$nameTwo Won", Toast.LENGTH_SHORT).show()
            score2++
            player2.text = "$score2"
            button1.isClickable= false
            button2.isClickable= false
            button3.isClickable= false
            button4.isClickable= false
            button5.isClickable= false
            button6.isClickable= false
            button7.isClickable= false
            button8.isClickable= false
            button9.isClickable= false
            Handler().postDelayed({
                reset(2)
            }, 1000)

        }else if (winnerPlayer == 0

            && button1.text.isNotEmpty() && button2.text.isNotEmpty() && button3.text.isNotEmpty()
            && button4.text.isNotEmpty() && button5.text.isNotEmpty() && button6.text.isNotEmpty()
            && button7.text.isNotEmpty() && button8.text.isNotEmpty() && button9.text.isNotEmpty()
        ){
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
            reset(activePlayer)
        }
    }
}