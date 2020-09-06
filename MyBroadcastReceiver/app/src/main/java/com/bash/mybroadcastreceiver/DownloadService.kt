package com.bash.mybroadcastreceiver

import android.app.IntentService
import android.content.Intent
import android.util.Log


// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
const val ACTION_FOO = "com.bash.mybroadcastreceiver.action.FOO"
const val ACTION_BAZ = "com.bash.mybroadcastreceiver.action.BAZ"

// TODO: Rename parameters
const val EXTRA_PARAM1 = "com.bash.mybroadcastreceiver.extra.PARAM1"
const val EXTRA_PARAM2 = "com.bash.mybroadcastreceiver.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions and extra parameters.
 */
class DownloadService : IntentService("DownloadService") {

    companion object{
        val TAG = DownloadService::class.java.simpleName
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "Download Service dijalankan")
        if(intent != null){
            try{
                Thread.sleep(5000)
            }catch (e: InterruptedException){
                e.printStackTrace()
            }

            val notifyFinishIntent = Intent(MainActivity.ACTION_DOWNLOAD_STATUS)
            sendBroadcast(notifyFinishIntent)
        }
    }
}
