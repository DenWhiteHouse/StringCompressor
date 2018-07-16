package com.example.android.stringcompressor;

import android.content.Context;
import android.view.View;

public class MainActivityPresenter {
    private StringCompressor mStringCompressor;
    private View mView;
    private Context mContex;

    public MainActivityPresenter(View view, Context context){
        mView =view;
        mContex=context;
    }

    public void compressString(String input){
        mStringCompressor = new StringCompressor(mContex);
        mStringCompressor.compressString(input);
        mView.updateResult(mStringCompressor.getmCompressedString());
    }

    public interface View{
        void updateResult(String compressedString);
    }
}
