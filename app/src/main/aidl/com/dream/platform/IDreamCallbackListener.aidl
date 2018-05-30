// IDreamCallbackListener.aidl
package com.dream.platform;

import com.dream.platform.parcel.EntityBaseEvent;

interface IDreamCallbackListener {
    void notifyMessage(int status);
    void notifySystemEvent(in EntityBaseEvent event);
}
