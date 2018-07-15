package com.example.android.stringcompressor;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    private static TextView mResultTV;
    private static EditText mInputEV;
    private static Button mCompressionButton;

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
                mResultTV.setText(compressString(mInputEV.getText().toString()));
            }
        });
    }

    public static String compressString(String input){
        if(input.isEmpty()){
            //check if the String is null (in case the check is done before this would serve as double check
            return null;
        }
        char[] inputCharArray =input.toCharArray();
        ArrayList<Character> compressionHelper = new ArrayList<Character>();
        //for sure the first element will be the same in both the arrays
        compressionHelper.add(inputCharArray[0]);
        int repetationCounter=0;
        for (int i=0;i<inputCharArray.length;i=i+repetationCounter){
            for(int j=0;inputCharArray[i]==inputCharArray[i+j];j++){
                repetationCounter=j;
            }
            compressionHelper.add(inputCharArray[i]);
            if(repetationCounter==0){
                repetationCounter=1;
            }
            compressionHelper.add(Integer.toString(repetationCounter).charAt(0));
            }
        return  compressionHelper.toString();
        }

    }

