package com.example.android.stringcompressor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static TextView mResultTV;
    private static EditText mInputEV;
    private static Button mCompressionButton;
    private StringCompressor mStringCompressor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultTV = findViewById(R.id.resultTV);
        mInputEV = findViewById(R.id.stringInputEditText);
        mCompressionButton = findViewById(R.id.compressButton);

        mCompressionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStringCompressor = new StringCompressor();
                mResultTV.setText(mStringCompressor.compressString(mInputEV.getText().toString()));
            }
        });
    }
}

