package com.dream.dreamaidlclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dream.dreamaidlclient.testapi.TestApiHelper;
import com.dream.platform.enums.EnumBaseItem;
import com.dream.platform.parcel.EntityBaseParcel;
import com.dream.platform.parcel.EnumBaseParcel;

public class MainActivity extends Activity {

    private static int mIntValue = 0;
    private TestApiHelper mTestApiHelper = null;

    private Button mSetAidlIntBtn;
    private Button mSetAidlByteBtn;
    private Button mSetAidlStringBtn;
    private Button mSetAidlBytesBtn;
    private Button mSetAidlBaseItemBtn;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestApiHelper = TestApiHelper.getTestApiHelper(getApplicationContext());
        mResultText = (TextView) findViewById(R.id.result_text);

        mSetAidlIntBtn = (Button) findViewById(R.id.set_aidl_int);
        mSetAidlIntBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mIntValue++;
                mTestApiHelper.setAidlIntValue(mIntValue);
                mResultText.setText("SetAidlInt: " + mTestApiHelper.getAidlIntValue());
            }
        });

        mSetAidlByteBtn = (Button) findViewById(R.id.set_aidl_byte);
        mSetAidlByteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntValue += 2;
                mTestApiHelper.setAidlByteValue((byte)mIntValue);
                mResultText.setText("SetAidlByte: " + mTestApiHelper.getAidlByteValue());
            }
        });

        mSetAidlStringBtn = (Button) findViewById(R.id.set_aidl_string);
        mSetAidlStringBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTestApiHelper.setAidlString("Hello World");
                mResultText.setText("SetAidlString: " + mTestApiHelper.getAidlString());
            }
        });

        mSetAidlBytesBtn = (Button) findViewById(R.id.set_aidl_bytes);
        mSetAidlBytesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] value = new byte[] {
                    (byte)33, (byte)34, (byte)35, (byte)36, (byte)37
                };
                mTestApiHelper.setAidlBytes(value);

                byte[] results = mTestApiHelper.getAidlBytes();
                StringBuffer buffer = new StringBuffer("SetAidlBytes: ");
                for (byte byteValue : results) {
                    buffer.append(byteValue + ",");
                }
                mResultText.setText(buffer.toString());
            }
        });

        mSetAidlBaseItemBtn = (Button) findViewById(R.id.set_aidl_base_item);
        mSetAidlBaseItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntityBaseParcel item = new EntityBaseParcel();
                item.mEnumParcel = EnumBaseParcel.BASE1;
                item.mEnumValue = EnumBaseItem.ITEM1;
                item.mIntValue = 12;
                item.mLongValue = 23;
                item.mBooleanValue = true;
                item.mFloatValue = 0.1f;
                item.mDoubleValue = 0.2f;
                item.mStringValue = "testBaseItem";
                mTestApiHelper.setBaseParcel(item);

                EntityBaseParcel destItem = mTestApiHelper.getBaseParcel();
                StringBuffer buffer = new StringBuffer();
                buffer.append("EntityBaseParcel mEnumParcel: " + destItem.mEnumParcel);
                buffer.append(", mEnumValue: " + destItem.mEnumValue);
                buffer.append(", mIntValue: " + destItem.mIntValue);
                buffer.append(", mLongValue: " + destItem.mLongValue);
                buffer.append(", mBooleanValue: " + destItem.mBooleanValue);
                buffer.append(", mFloatValue: " + destItem.mFloatValue);
                buffer.append(", mDoubleValue: " + destItem.mDoubleValue);
                buffer.append(", mStringValue: " + destItem.mStringValue);
                mResultText.setText(buffer);
            }
        });
    }
}
