package com.giftech.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    private EditText mMessageEditText;

    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHead;
    private TextView mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = (EditText) findViewById(R.id.et_message);

        mReplyHead = (TextView) findViewById(R.id.tv_reply_head);
        mReply = (TextView) findViewById(R.id.tv_reply);
    }

    public void launchSecondActivity(View view) {
        String message = mMessageEditText.getText().toString();

        Intent goSecond = new Intent(this, SecondActivity.class);
        goSecond.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(goSecond,TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHead.setVisibility(View.VISIBLE);
                mReply.setText(reply);
                mReply.setVisibility(View.VISIBLE);
            }
        }
    }
}