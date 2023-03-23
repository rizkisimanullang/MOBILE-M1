package com.example.rollin_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Letak button
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener pada saat ketika pengguna menekan tombol
        rollButton.setOnClickListener { rollDice() }

        //Pada saat aplikasi dibuka
        rollDice()

    }

    /**
     * Dadu bergulir, kemudian update perubahan layar berdasarkan hasil gulir.
     */
    private fun rollDice() {
        // Objek untuk dadu 1
        val dice = Dice(6)


        //Panggil method roll() untuk bergulir
        val diceRoll = dice.roll()

        // Panggil ImageView di layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll 1
        val drawableResourceForDice1 = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        // Update ImageView drawable resource ID
        diceImage.setImageResource(drawableResourceForDice1)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {

    /**
     * Fungsi untuk menggulirkan dadu dengan mengembalikan nilai int
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}