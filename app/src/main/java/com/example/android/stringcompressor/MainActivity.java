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

    public static String compressString(String input) {
        if (input.isEmpty()) {
            //check if the String is null (in case the check is done before this would serve as double check
            return "no input detected";
        }
        final char[] inputCharArray = input.toCharArray();
        final ArrayList<Character> compressionHelper = new ArrayList<Character>();
        int repetationCounter;
        for (int i = 0; i < inputCharArray.length; i = i + 1 + repetationCounter) {
            repetationCounter = 0;
            if ((i + 1) != inputCharArray.length) {
                for (int j = 0; inputCharArray[i] == inputCharArray[i + j]; j++) {
                    repetationCounter = j;
                    if ((j + 1) == inputCharArray.length) {
                        //the string is a vector of only one char repeated
                        break;
                    }
                    if ((j + i + 1) == inputCharArray.length) {
                        //the string ends with a repeatedchar
                        break;
                    }
                }
            }

            compressionHelper.add(inputCharArray[i]);
            if (repetationCounter == 0) {
                compressionHelper.add('1');
            } else {
                compressionHelper.add(Integer.toString(repetationCounter + 1).charAt(0));
            }
        }
        if (compressionHelper.size() < inputCharArray.length) {
            String listPolisher = new String();
            for (int i = 0; i < compressionHelper.size(); i++) {
                listPolisher = listPolisher + compressionHelper.get(i);
            }
            return listPolisher;
        } else {
            return input;
        }
    }
}

