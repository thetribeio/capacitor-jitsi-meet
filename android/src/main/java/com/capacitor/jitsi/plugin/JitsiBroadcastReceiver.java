package com.capacitor.jitsi.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import timber.log.Timber;

public class JitsiBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "JitsiBroadcastReceiver";
    private Jitsi jitsi;

    public void setModule(Jitsi module) {
        this.jitsi = module;
    }

    public void onReceive(Context context, Intent intent) {
        String eventName = (String) intent.getSerializableExtra("eventName");
        String extraValue1 = (String) intent.getSerializableExtra("extraValue1");
        String extraValue2 = (String) intent.getSerializableExtra("extraValue2");
        Timber.tag(TAG).d("onReceive: " + eventName + " " + extraValue1 + " " + extraValue2);
        if (jitsi != null) {
            if(eventName.equals("onReceiveChatMessage")) {
                jitsi.onEventReceived(eventName, extraValue1, extraValue2);
            } else {
                jitsi.onEventReceived(eventName);
            }
        }
    }
}
