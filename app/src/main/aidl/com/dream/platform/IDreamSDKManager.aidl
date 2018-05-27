// IDreamSDKManager.aidl
package com.dream.platform;

import com.dream.platform.IDreamTestAidl;
import com.dream.platform.IDreamCallbackListener;

interface IDreamSDKManager {

    void registerCallbackListener(IDreamCallbackListener listener);

    void unregisterCallbackListener(IDreamCallbackListener listener);

    IDreamTestAidl getDreamTestApi();
}
