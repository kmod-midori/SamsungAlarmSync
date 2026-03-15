package com.sec.android.app.clockpackage.alarm.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmSecurityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "onReceive ${intent.action}")
    }

    companion object {
        private const val TAG = "AlarmSecurityReceiver"
    }
}