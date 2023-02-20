package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            Intent.ACTION_BATTERY_LOW -> Toast.makeText(context, "ACTION_BATTERY_LOW", Toast.LENGTH_SHORT).show()
            Intent.ACTION_POWER_CONNECTED -> Toast.makeText(context, "ACTION_POWER_CONNECTED", Toast.LENGTH_SHORT).show()
            Intent.ACTION_POWER_DISCONNECTED -> Toast.makeText(context, "ACTION_POWER_DISCONNECTED", Toast.LENGTH_SHORT).show()
            Intent.ACTION_BOOT_COMPLETED -> Toast.makeText(context, "ACTION_BOOT_COMPLETED", Toast.LENGTH_SHORT).show()
            ConnectivityManager.CONNECTIVITY_ACTION -> Toast.makeText(context, "Network Change", Toast.LENGTH_SHORT).show()
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->
            {
                val state = intent.getBooleanExtra("state",false)
                if (state){
                    Toast.makeText(context, "Airplan ON", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Airplan OFF", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}