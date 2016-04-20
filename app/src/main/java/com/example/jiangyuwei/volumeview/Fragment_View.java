package com.example.jiangyuwei.volumeview;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jiangyuwei on 16/4/11.
 */
public class Fragment_View extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.custon,parent,false);
        return v;
    }
}
