package com.example.jiangyuwei.volumeview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.custom_view);
        if (fragment==null){
            fragment = new Fragment_View();
            fm.beginTransaction().add(R.id.custom_view,fragment).commit();
        }
    }
}
