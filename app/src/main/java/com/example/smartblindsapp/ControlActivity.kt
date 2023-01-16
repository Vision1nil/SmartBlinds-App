package com.example.smartblindsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import com.example.smartblindsapp.databinding.ActivityControlBinding
import org.json.JSONObject
import java.io.BufferedOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class ControlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

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
        //if //inside temp > target
            // close blind set to 0+
        //else if // inside temp < target
            //if //external temp > internal
                //open the blind - set to 90

            //else if //external temp < internal
                // close the blind set to 0
    }

    private fun postBlindInfo(bondIp: String, blindAction: String) {

        val urlString = "http://$bondIp/v2/devices/944b6fcde5ab645b/actions/$blindAction"

    }

    private fun openClose() {
        if (binding.btnOpenOrClose.text.equals("Open")) {
            binding.btnOpenOrClose.text = "Close"
            postBlindInfo("192.168.87.22", "Open")
        }
        else {
            binding.btnOpenOrClose.text = "Open"
        }
    }

    private fun changeModes() {
        if (binding.btnEnableAutomatedOrManualTilt.text.equals("Enable\n automated tilt")) {
            binding.btnEnableAutomatedOrManualTilt.text = "Enable\n manual tilt"
            binding.tvManualOrAutomatic.text = "Mode: Automated"
        }
        else {
            binding.btnEnableAutomatedOrManualTilt.text="Enable\n automated tilt"
            binding.tvManualOrAutomatic.text = "Mode: Manual"
        }

    }
}