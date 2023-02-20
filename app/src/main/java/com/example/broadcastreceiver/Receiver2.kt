package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver2 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            "com.example.action.value" -> Toast.makeText(context, "Your flag "+intent.getIntExtra("flag",0).toString(), Toast.LENGTH_SHORT).show()
        }
    }
}