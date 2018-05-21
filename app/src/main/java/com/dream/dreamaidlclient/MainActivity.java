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
    }
}
