package com.example.smartblindsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smartblindsapp.databinding.ActivityControlBinding


class ControlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnEnableAutomatedOrManualTilt.setOnClickListener {
            changeModes();
        }
        binding.btnOpenOrClose.setOnClickListener {
            openClose();
        }
        binding.ibLogoControl.setOnClickListener {
            startActivity(Intent(this@ControlActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun openClose() {
        if(binding.btnOpenOrClose.text.equals("Open")) {
            binding.btnOpenOrClose.text = "Close"
        } else{
            binding.btnOpenOrClose.text = "Open"
        }
    }

    private fun changeModes() {
        if(binding.btnEnableAutomatedOrManualTilt.text.equals( "Enable\n automated tilt")) {
            binding.btnEnableAutomatedOrManualTilt.text = "Enable\n manual tilt"
            binding.tvManualOrAutomatic.text = "Mode: Automated"
        } else{
            binding.btnEnableAutomatedOrManualTilt.text="Enable\n automated tilt"
            binding.tvManualOrAutomatic.text = "Mode: Manual"
        }

    }
}