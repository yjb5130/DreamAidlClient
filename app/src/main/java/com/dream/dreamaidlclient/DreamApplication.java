package com.dream.dreamaidlclient;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.dream.platform.IDreamSDKManager;

import java.util.ArrayList;
import java.util.List;

public class DreamApplication extends Application {

    private final static String TAG = "DreamApplication";
    private static Context mContext;
    private static Intent serviceIntent = null;
    private static IDreamSDKManager mDreamManager = null;
    private static List<ServiceConnectListener> mConnectedListenerLists = new ArrayList();

    public static void getDreamManager(ServiceConnectListener connectListener) {
        if (mDreamManager == null) {
            synchronized(mConnectedListenerLists) {
                if (mConnectedListenerLists != null) {
                    mConnectedListenerLists.add(connectListener);
                }
            }
            serviceIntent = new Intent();
            serviceIntent.setPackage("com.dream.dreamaidlservice");
            serviceIntent.setAction("com.dream.dreamaidlservice.DreamAidlService");
            mContext.bindService(serviceIntent, mConn, Context.BIND_AUTO_CREATE);
        }
        else if (connectListener != null) {
            connectListener.OnConnected(mDreamManager);
        }
    }

    private static ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDreamManager = IDreamSDKManager.Stub.asInterface(service);
            if (mConnectedListenerLists != null && mConnectedListenerLists.size() > 0) {
                synchronized(mConnectedListenerLists) {
                    for (ServiceConnectListener connectListener : mConnectedListenerLists) {
                        try {
                            Log.d(TAG, "Invoke listener");
                            connectListener.OnConnected(mDreamManager);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mDreamManager = null;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "======== onCreate =======");
        mContext = this;

        if (mDreamManager == null) {
            serviceIntent = new Intent();
            serviceIntent.setPackage("com.dream.dreamaidlservice");
            serviceIntent.setAction("com.dream.dreamaidlservice.DreamAidlService");
            mContext.bindService(serviceIntent, mConn, Context.BIND_AUTO_CREATE);
        }
    }

    @Override
    public void onTerminate() {
        Log.d(TAG, "======== onTerminate =======");
        unbindService(mConn);
        super.onTerminate();

    }
}
