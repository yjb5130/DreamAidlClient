package com.dream.dreamaidlclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dream.dreamaidlclient.testapi.TestApiHelper;

public class MainActivity extends Activity {

    private static int mIntValue = 0;
    private TestApiHelper mTestApiHelper = null;

    private Button mSetAidlIntBtn;
    private Button mSetAidlByteBtn;
    private Button mSetAidlStringBtn;
    private Button mSetAidlBytesBtn;
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
    }
}
