package com.example.android.stringcompressor;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

public class StringCompressor {
    private char[] mInputCharArray;
    private ArrayList<Character> mCompressionHelper;
    private int repetationCounter;
    private String mCompressedString;
    private Context mContex;

    public StringCompressor(Context context){
        mCompressionHelper = new ArrayList<Character>();
        mContex=context;
    }

    public void setCompressedString(String compressedString){
        mCompressedString = compressedString;
    }

    public String getmCompressedString(){
        return  mCompressedString;
    }


    public void compressString(String input) {
        String listPolisher = new String();
        if (input.isEmpty()) {
            //check if the String is null (in case the check is done before this would serve as double check
            setCompressedString(mContex.getString(R.string.empty_input));
        }
        else {
            mInputCharArray = input.toCharArray();
            for (int i = 0; i < mInputCharArray.length; i = i + 1 + repetationCounter) {
                repetationCounter = 0;
                if ((i + 1) != mInputCharArray.length) {
                    for (int j = 0; mInputCharArray[i] == mInputCharArray[i + j]; j++) {
                        repetationCounter = j;
                        if ((j + 1) == mInputCharArray.length) {
                            //the string is a vector of only one char repeated
                            break;
                        }
                        if ((j + i + 1) == mInputCharArray.length) {
                            //the string ends with a repeatedchar
                            break;
                        }
                    }
                }
                mCompressionHelper.add(mInputCharArray[i]);
                if (repetationCounter == 0) {
                    mCompressionHelper.add('1');
                } else {
                    mCompressionHelper.add(Integer.toString(repetationCounter + 1).charAt(0));
                }
            }
            for (int i = 0; i < mCompressionHelper.size(); i++) {
                listPolisher = listPolisher + mCompressionHelper.get(i);
            }
            setCompressedString(listPolisher);
        }
    }
}
