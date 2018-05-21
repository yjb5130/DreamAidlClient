package com.dream.dreamaidlclient.testapi;

import android.content.Context;
import android.os.RemoteException;

import com.dream.dreamaidlclient.DreamApplication;
import com.dream.dreamaidlclient.ServiceConnectListener;
import com.dream.platform.IDreamSDKManager;

public class TestApiHelper {

    private Context mContext;
    private IDreamSDKManager mDreamManager = null;
    private static TestApiHelper mTestApiHelper = null;

    private TestApiHelper(Context context) {
        mContext = context;
        DreamApplication.getDreamManager(new ServiceConnectListener() {
            @Override
            public void OnConnected(IDreamSDKManager sdkManager) {
                mDreamManager = sdkManager;
            }
        });
    }

    public static TestApiHelper getTestApiHelper(Context context) {
        if (mTestApiHelper == null) {
            mTestApiHelper = new TestApiHelper(context);
        }
        return mTestApiHelper;
    }

    public int getAidlIntValue() {
        int value = 0;
        try {
            if (mDreamManager != null) {
                value = mDreamManager.getDreamTestApi().getAidlIntValue();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void setAidlIntValue(int value) {
        try {
            if (mDreamManager != null) {
                mDreamManager.getDreamTestApi().setAidlIntValue(value);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public byte getAidlByteValue() {
        byte value = 0;
        try {
            if (mDreamManager != null) {
                value = mDreamManager.getDreamTestApi().getAidlByteValue();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void setAidlByteValue(byte value) {
        try {
            if (mDreamManager != null) {
                mDreamManager.getDreamTestApi().setAidlByteValue(value);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getAidlString() {
        String string = null;
        try {
            if (mDreamManager != null) {
                string = mDreamManager.getDreamTestApi().getAidlString();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return string;
    }

    public void setAidlString(String string) {
        try {
            if (mDreamManager != null) {
                mDreamManager.getDreamTestApi().setAidlString(string);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public byte[] getAidlBytes() {
        byte[] value = null;
        try {
            if (mDreamManager != null) {
                value = mDreamManager.getDreamTestApi().getAidlBytes();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void setAidlBytes(byte[] value) {
        try {
            if (mDreamManager != null) {
                mDreamManager.getDreamTestApi().setAidlBytes(value);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
