package com.appbusters.robinkamboj.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appbusters.robinkamboj.customviews.customviews.MyCustomViewOne;

public class ShapesActivity extends AppCompatActivity {

    MyCustomViewOne customViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

        customViewOne = (MyCustomViewOne) findViewById(R.id.my_custom_view);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.swap:{
                customViewOne.swapColor();
                break;
            }
        }
    }
}
