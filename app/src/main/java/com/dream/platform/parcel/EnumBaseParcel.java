package com.dream.platform.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public enum EnumBaseParcel implements Parcelable {
    BASE1,
    BASE2,
    BASE3;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EnumBaseParcel> CREATOR = new Creator<EnumBaseParcel>() {
        @Override
        public EnumBaseParcel createFromParcel(Parcel in) {
            return EnumBaseParcel.values()[in.readInt()];
        }

        @Override
        public EnumBaseParcel[] newArray(int size) {
            return new EnumBaseParcel[size];
        }
    };
}
