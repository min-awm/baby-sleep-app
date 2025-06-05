package com.example.babysleep;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class AppFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TYPE_INCOMING_CALL = "type_incoming_call";

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.i("xxxxx", "Fcm token is: " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage message) {
        super.onMessageReceived(message);
        if (message.getData() != null && TYPE_INCOMING_CALL.equals(message.getData().get("type"))) {
            showIncomingCallPopup();
        }
    }

    private void showIncomingCallPopup() {
        Intent intent = new Intent(this, CallingService.class);
        startService(intent);
    }
}
