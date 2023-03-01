package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastreceiver.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import org.greenrobot.eventbus.EventBus
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    val myReceiver = MyReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// master

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val intentFilter = IntentFilter()
            intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
            intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
            intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
            intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED)
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
            intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            intentFilter.priority = 1
            registerReceiver(myReceiver,intentFilter)
        }

        binding.btnSendValue.setOnClickListener {
//            val i = Intent("com.example.action.value")
//            i.putExtra("flag",10)
//            sendBroadcast(i)
            EventBus.getDefault().post(10)
            val inttent = Intent(this,Activity2::class.java)
            startActivity(inttent)
        }

        /// send intent with permission to anther app

        binding.btnSend.setOnClickListener {
            val i = Intent("com.example.broadcast")
            sendBroadcast(i,android.Manifest.permission.SEND_SMS)
            var snackbar = Snackbar.make(binding.mainLayout,"Connected", Snackbar.LENGTH_SHORT)
            snackbar.duration = Snackbar.LENGTH_INDEFINITE
            snackbar.show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
       unregisterReceiver(myReceiver)
    }
}
// new test branch