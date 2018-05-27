package com.dream.platform.parcel;

import android.os.Parcel;
import android.os.Parcelable;

import com.dream.platform.enums.EnumBaseItem;

public class EntityBaseParcel implements Parcelable {

    public EnumBaseParcel mEnumParcel;
    public EnumBaseItem mEnumValue;
    public int mIntValue;
    public long mLongValue;
    public boolean mBooleanValue;
    public float mFloatValue;
    public double mDoubleValue;
    public String mStringValue;

    public EntityBaseParcel() {

    }

    protected EntityBaseParcel(Parcel in) {
        mEnumParcel = (EnumBaseParcel)in.readSerializable();
        mEnumValue = EnumBaseItem.values()[in.readInt()];
        mIntValue = in.readInt();
        mLongValue = in.readLong();
        mBooleanValue = in.readByte() != 0;
        mFloatValue = in.readFloat();
        mDoubleValue = in.readDouble();
        mStringValue = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mEnumParcel);
        dest.writeInt(mEnumValue.ordinal());
        dest.writeInt(mIntValue);
        dest.writeLong(mLongValue);
        dest.writeByte((byte) (mBooleanValue ? 1 : 0));
        dest.writeFloat(mFloatValue);
        dest.writeDouble(mDoubleValue);
        dest.writeString(mStringValue);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EntityBaseParcel> CREATOR = new Creator<EntityBaseParcel>() {
        @Override
        public EntityBaseParcel createFromParcel(Parcel in) {
            return new EntityBaseParcel(in);
        }

        @Override
        public EntityBaseParcel[] newArray(int size) {
            return new EntityBaseParcel[size];
        }
    };
}
