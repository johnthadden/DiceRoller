package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /**
     * Roll dice when button is tapped and update ImageView with corresponding random 'roll.'
     */

    private fun rollDice() {
        //Create Dice object with 6 sides and roll
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Find ImageView in Layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine which dice picture to display dependent on the 'random' number assigned on button click
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update ImageView with correct drawable ID
        diceImage.setImageResource(drawableResource)

        //Update content description
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}