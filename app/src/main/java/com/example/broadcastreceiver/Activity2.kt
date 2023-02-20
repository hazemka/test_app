package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class Activity2 : AppCompatActivity() {
    private lateinit var receiver2: Receiver2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
//        if (Build.VERSION.SDK_INT >=26){
//            val intentFilter = IntentFilter()
//            intentFilter.addAction("com.example.action.value")
//            receiver2 = Receiver2()
//            registerReceiver(receiver2,intentFilter)
//        }

    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }
    @Subscribe
    fun onMessageEvent(value:Int){
        Toast.makeText(this, "Value is $value", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}