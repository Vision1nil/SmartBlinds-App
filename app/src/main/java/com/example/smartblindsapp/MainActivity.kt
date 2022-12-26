package com.example.smartblindsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.smartblindsapp.R.*
import com.example.smartblindsapp.databinding.ActivityMainBinding
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    // initializing the binding here. To use in other activty or fragments replace the "ActivityMainBinding"
    // with "ActivityNameBinding" or "FragmentNameBinding"
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding.root = the root view (typically the constraint or relative layout of the screen)
        val mainView = binding.root
        setContentView(mainView)

        // when btn is clicked, load to the control activity.
        binding.btnControlBlinds.setOnClickListener {
            startActivity(Intent(this@MainActivity, ControlActivity::class.java))
            finish()
        }
        binding.ibTargetTempUp.setOnClickListener{
            increaseTemp();
        }
        binding.ibTargetTempDown.setOnClickListener{
            decreaseTemp();
        }



    }

    private fun decreaseTemp() {
        val targetTemp = binding.tvTargetTemp.text.substring(0,2).toInt()-1
        binding.tvTargetTemp.text = "$targetTemp ° F"
    }

    private fun increaseTemp() {
        val targetTemp = binding.tvTargetTemp.text.substring(0,2).toInt()+1
        binding.tvTargetTemp.text = "$targetTemp ° F"
    }


    //  Making an HTTP API request to OpenWeatherMap to get weather data
//    private fun getWeatherData(cityLocation: String): String {
//
//
//        val city = cityLocation
//        val apiKey = "f37a62f535eae00acd40906fa7a3c3a7"
//        val apiURL = "https://api.openweathermap.org/data/2.5/weather?q=$city&mode=metric&units=imperial&appid=$apiKey"
//        val resultJSON = URL(apiURL).readText()
//
//        val jsonObj = JSONObject(resultJSON)
//
//        return jsonObj.getJSONArray("weather").getJSONObject(0).getString("main")
//
//
//    }
}

























