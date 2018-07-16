package com.example.android.stringcompressor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View{
    private static TextView mResultTV;
    private static EditText mInputEV;
    private static Button mCompressionButton;
    private MainActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultTV = findViewById(R.id.resultTV);
        mInputEV = findViewById(R.id.stringInputEditText);
        mCompressionButton = findViewById(R.id.compressButton);
        mPresenter = new MainActivityPresenter(this,this);

        mCompressionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.compressString(mInputEV.getText().toString());
            }
        });
    }

    @Override
    public void updateResult(String compressedString) {
        mResultTV.setText(compressedString);
    }
}

