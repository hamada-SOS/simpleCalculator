package com.example.hclator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.hclator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun numberEvent(view: View) {
        binding.input.append((view as Button).text)
    }

    fun opratorEvent(view: View) {
        if ((view as Button).text == "x") {
            binding.input.append("*")
        } else {
            binding.input.append((view as Button).text)
        }
    }

    fun equalEvent(view: View) {
        val e = ExpressionBuilder(binding.input.text.toString()).build()
        var result = e.evaluate()
        binding.output.text = result.toString()
    }

    fun eraseBtn(view: View) {
        binding.input.text = ""
        binding.output.text = ""

    }

}



