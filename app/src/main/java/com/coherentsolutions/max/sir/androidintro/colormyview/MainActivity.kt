package com.coherentsolutions.max.sir.androidintro.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.toColorInt
import androidx.databinding.DataBindingUtil
import com.coherentsolutions.max.sir.androidintro.colormyview.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val l: List<View>
        val clickable: ActivityMainBinding =
            binding.apply {
                l = listOf(textView, textView2, textView3, textView4, button, constraintLayout)
            }
        l.forEach {
            it.setOnClickListener {
                val colorString = '#' + createRandomIntegerString(0x08)
                when (it) {
                    is TextView -> it.text = colorString
                    is Button -> it.text = colorString
                    else -> Toast.makeText(this,"color is $colorString",Toast.LENGTH_SHORT).show()
                }
                it.setBackgroundColor(Color.parseColor(colorString))
            }
        }
    }


    internal fun createRandomIntegerString(length: Int): String {
        val stringBuilder = StringBuilder()
        val hexsInterpolation = "0123456789abcdef"
        for (i in 0 until length) {
            val tmpInt = Random.nextInt()
            val x = abs(tmpInt) % 16
            stringBuilder.append(hexsInterpolation[x])
        }
        return stringBuilder.toString()
    }
}