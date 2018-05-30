package com.dream.platform.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class EntityBaseEvent implements Parcelable {

    public int msgID;
    public String info;
    public String error;

    public EntityBaseEvent() {

    }

    protected EntityBaseEvent(Parcel in) {
        msgID = in.readInt();
        info = in.readString();
        error = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(msgID);
        dest.writeString(info);
        dest.writeString(error);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EntityBaseEvent> CREATOR = new Creator<EntityBaseEvent>() {
        @Override
        public EntityBaseEvent createFromParcel(Parcel in) {
            return new EntityBaseEvent(in);
        }

        @Override
        public EntityBaseEvent[] newArray(int size) {
            return new EntityBaseEvent[size];
        }
    };
}
