package com.bash.myservice

import android.app.IntentService
import android.content.Intent
import android.util.Log


// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
const val ACTION_FOO = "com.bash.myservice.action.FOO"
const val ACTION_BAZ = "com.bash.myservice.action.BAZ"

// TODO: Rename parameters
const val EXTRA_PARAM1 = "com.bash.myservice.extra.PARAM1"
const val EXTRA_PARAM2 = "com.bash.myservice.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions and extra parameters.
 */
class MyIntentService : IntentService("MyIntentService") {

    companion object{
        internal const val EXTRA_DURATION = "extra_duration"
        private val TAG = MyIntentService::class.java.simpleName
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent: Mulai.......")
        val duration = intent?.getLongExtra(EXTRA_DURATION, 0)as Long
        try {
            Thread.sleep(duration)
            Log.d(TAG, "onHandleIntent: Selesai.......")
        } catch (e: InterruptedException){
            e.printStackTrace()
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

}
