package com.brianroper.wearable;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by brianroper on 6/13/16.
 */
public class WatchListener extends WearableListenerService {

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        if(messageEvent.getPath().equals("/message_path")){

            String message = new String(messageEvent.getData());

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra("message", message);
            LocalBroadcastManager.getInstance(this)
                    .sendBroadcast(intent);
        }
        else{

            super.onMessageReceived(messageEvent);
        }
    }
}
