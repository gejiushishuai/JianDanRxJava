package com.socks.jiandan.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.socks.jiandan.model.NetWorkEvent;
import com.socks.jiandan.utils.NetWorkUtil;

import de.greenrobot.event.EventBus;

public class NetStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(
                ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (NetWorkUtil.isNetWorkConnected(context)) {
                EventBus.getDefault().post(new NetWorkEvent(NetWorkEvent.AVAILABLE));
            } else {
                EventBus.getDefault().post(new NetWorkEvent(NetWorkEvent.UNAVAILABLE));
            }
        }
    }
}
