package com.giftech.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent getData = getIntent();
        String message = getData.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.tv_message);

        textView.setText(message);

        mReply = (EditText) findViewById(R.id.et_reply);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}