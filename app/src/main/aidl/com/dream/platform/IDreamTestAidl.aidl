// IDreamTestAidl.aidl
package com.dream.platform;

import com.dream.platform.parcel.EntityBaseParcel;

interface IDreamTestAidl {
    int getAidlIntValue();
    void setAidlIntValue(int value);

    byte getAidlByteValue();
    void setAidlByteValue(byte value);

    String getAidlString();
    void setAidlString(String string);

    byte[] getAidlBytes();
    void setAidlBytes(in byte[] value);

    EntityBaseParcel getBaseParcel();
    void setBaseParcel(in EntityBaseParcel item);
}
